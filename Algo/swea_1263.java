import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1263 {

	static int T; // 테스트케이스
	static int N; // 네트워크의 노드 수
	static int[][] adj; // 인접 행렬
	static int min; // 최소값
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 사람 네트워크2 - 플로이드워샬 알고리즘
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());

			adj = new int[N][N];
			for (int r = 0; r < N; r++) { // 초기 인접행렬 생성(입력)
				for (int c = 0; c < N; c++) {
					adj[r][c] = Integer.parseInt(st.nextToken());
					if (adj[r][c] != 1 && r != c) {
						adj[r][c] = 1001;
					}
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						adj[i][j] = Math.min(adj[i][k] + adj[k][j], adj[i][j]);
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			for(int r=0; r<N; r++) {
				int result = 0;
				for(int c=0; c<N; c++) {
					result += adj[r][c];
				}
				min = Math.min(result, min);
			}
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
	}
}
