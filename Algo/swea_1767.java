import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1767 {

	static int T;	// 테스트케이스
	static int N;	// 크기
	static int[][] maxi;	// 멕시노스
	static List<Core> list;	// core 위치
	static int maxcore;	// core의 최대 개수
	static int minline;	// 전선의 최소 개수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 프로세서 연결하기
		T = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			maxi = new int[N][N];
			list = new ArrayList<>();
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int c=0; c<N; c++) {
					maxi[r][c] = Integer.parseInt(st.nextToken());
					if(maxi[r][c]==1) {
						list.add(new Core(r, c));
					}
				}
			}
			
			// 가장자리에 있는 core는 탐색에서 제외 -> 전선 길이=0
			for(int l=0; l<list.size(); l++) {
				int x = list.get(l).x;
				int y = list.get(l).y;
				
				if(x==0 || y==0 || x==N-1 || y==N-1) {
					list.remove(l);
					l--;
				}
			}
			
			/*for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).x +" "+list.get(i).y);
			}*/
			maxcore = Integer.MIN_VALUE;
			minline = Integer.MAX_VALUE;
			
			dfs(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(minline).append("\n");
		}
		System.out.println(sb);
	}
	
	static int[] xdeltas = {-1,1,0,0};
	static int[] ydeltas = {0,0,-1,1};
	
	static void dfs(int idx, int core, int line) {
		if(idx == list.size()) {
			if(maxcore < core) {	// 우선 순위1 - 연결된 core 최대
				maxcore = core;
				minline = line;
			} else if(maxcore == core) {
				minline = Math.min(minline, line);
			}
			
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nr = list.get(idx).x;
			int nc = list.get(idx).y;
			int cnt = 0;
			
			while(true) {
				nr += xdeltas[d];
				nc += ydeltas[d];
				
				if(nr <0 || nc <0 || nr >=N || nc >=N) {
					break;
				}
				
				if(maxi[nr][nc]==1) {	// 전선이나 core 만났을 경우
					cnt=0;
					break;
				}
				
				cnt++;
			}
			
			int r = list.get(idx).x;
			int c = list.get(idx).y;
			for(int i=0; i<cnt; i++) {
				r += xdeltas[d];
				c += ydeltas[d];
				
				maxi[r][c] = 1;
			}
			
			if(cnt == 0) {
				dfs(idx+1, core, line);
			} else {
				dfs(idx+1, core+1, line+cnt);
				
				r = list.get(idx).x;
				c = list.get(idx).y;
				
				for(int i=0; i<cnt; i++) {	// 초기 입력 상태
					r += xdeltas[d];
					c += ydeltas[d];
					
					maxi[r][c] = 0;
				}
			}
		}
	}
	
	static class Core{
		int x, y;

		public Core(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
