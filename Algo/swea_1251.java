import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class swea_1251 {

	static int T;	// 테스트 케이스
	static int N;	// 지도 크기
	static int[][] map;	// 지도
	static int[][] mintime;	// 소요시간
	static boolean[][] visited;	// 방문확인
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// 보급로
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			mintime = new int[N][N];
			visited = new boolean[N][N];
			
			for(int r=0; r<N; r++) {
				String str = br.readLine();
				for(int c=0; c<N; c++) {
					map[r][c] = str.charAt(c) - '0';
					mintime[r][c] = Integer.MAX_VALUE;
				}
			}
			
			go();
			
			sb.append("#").append(t).append(" ").append(mintime[N-1][N-1]).append("\n");
		}
		System.out.print(sb);
	}
	
	// 복구 시간이 가장 작은 경로 구하기
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};	// 이동 - 상하좌우만 가능
	static void go() {
		PriorityQueue<Area> pq = new PriorityQueue<>();
		pq.offer(new Area(0,0,0));	// 출발점 - 복구시간 : 0
		mintime[0][0] = 0;
		visited[0][0] = true;
		
		while(!pq.isEmpty()) {
			Area current = pq.poll();
			int a = current.x;
			int b = current.y;
			
			for(int d=0; d<4; d++) {
				int nr = a + deltas[d][0];
				int nc = b + deltas[d][1];
				
				if(isIn(nr,nc) && !visited[nr][nc]) {
					if(mintime[nr][nc] > mintime[a][b] + map[nr][nc]) {
						mintime[nr][nc] = mintime[a][b] + map[nr][nc];
						pq.offer(new Area(nr, nc, mintime[nr][nc]));
						visited[nr][nc] = true;
					}
				}
				
				if(nr==N-1 && nc==N-1) {	// 도착지점에 도달
					return;
				}
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

	static class Area implements Comparable<Area>{
		int x,y,re;

		public Area(int x, int y, int re) {
			super();
			this.x = x;
			this.y = y;
			this.re = re;
		}

		@Override
		public int compareTo(Area o) {
			return Integer.compare(this.re, o.re);
		}
	}

}
