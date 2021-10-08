import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4014 {

	static int T; // 테스트 케이스
	static int N; // 철별지대
	static int X; // 경사로 가로 길이
	static int[][] height; // 지형 높이 정보
	static int result; // 설치 가능한 활주로 개수
	static boolean[][] visited;	// 설치한 곳 확인
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 활주로 건설
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			height = new int[N][N];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					height[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = 0;
			
			visited = new boolean[N][N];	
			outer:for (int r = 0; r < N; r++) {	// 행별로 가능한 곳 찾기
				for (int c = 1; c < N; c++) {
					int current = height[r][c-1];
					if(current != height[r][c]) {
						int minus = current - height[r][c];
						if(Math.abs(minus)>=2) continue outer;
						if(!rowcheck(new Point(r,c,minus))) continue outer;
					}
				}
				result++;
			}
			
			visited = new boolean[N][N];
			outer:for (int c = 0; c < N; c++) {	// 열별로 가능한 곳 찾기
				for (int r = 1; r < N; r++) {
					int current = height[r-1][c];
					if(current != height[r][c]) {
						int minus = current - height[r][c];
						if(Math.abs(minus)>=2) continue outer;
						if(!calcheck(new Point(r,c,minus))) continue outer;
					}
				}
				result++;
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}

	static boolean rowcheck(Point idx) {
		int r = idx.x;
		int c = idx.y;
		int minus = idx.w;
		int zero = 1;
		
		if(minus==1) {
			visited[r][c]=true;
			for(int nc=c+1; nc<N; nc++) {
				if(height[r][nc] == height[r][nc-1] && !visited[r][nc]) {
					zero++;
					visited[r][nc]=true;
					if(zero==X) {
						return true;
					}
				}else {
					return false;
				}
			}	
		}else {
			visited[r][c-1]=true;
			for(int nc=c-2; nc>=0; nc--) {
				if(height[r][nc] == height[r][nc+1] && !visited[r][nc]) {
					zero++;
					visited[r][nc]=true;
					if(zero==X) {
						return true;
					}
				}else {
					return false;
				}
			}
		}
		
		if(zero<X) {
			return false;
		}
		return true;
	}
	
	static boolean calcheck(Point idx) {
		int r = idx.x;
		int c = idx.y;
		int minus = idx.w;
		int zero = 1;
		
		if(minus==1) {
			visited[r][c]=true;
			for(int nr=r+1; nr<N; nr++) {
				if(height[nr][c] == height[nr-1][c] && !visited[nr][c]) {
					zero++;
					visited[nr][c]=true;
					if(zero==X) {
						return true;
					}
				}else {
					return false;
				}
			}	
		}else {
			visited[r-1][c]=true;
			for(int nr=r-2; nr>=0; nr--) {
				if(height[nr][c] == height[nr+1][c] && !visited[nr][c]) {
					zero++;
					visited[nr][c]=true;
					if(zero==X) {
						return true;
					}
				}else {
					return false;
				}
			}
		}
		
		if(zero<X) {
			return false;
		}
		return true;
	}
	
	static class Point{
		int x,y,w;

		public Point(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
}