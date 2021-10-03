import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5215 {

	static int TC;	// 테스트 케이스
	static int N;	// 재료 수
	static int L;	// 제한 칼로리
	static int[] T;	// 맛
	static int[] K;	// 칼로리
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 햄버거 다이어트
		TC = Integer.parseInt(br.readLine());
	
		for(int t=1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			T = new int[N+1];
			K = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				T[i] = Integer.parseInt(st.nextToken());
				K[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] D = new int[N+1][L+1];
			
			for(int i=1; i<=N; i++) {
				for(int w=1; w<=L; w++) {
					if(K[i] <= w) {
						D[i][w] = Math.max(D[i-1][w], T[i]+D[i-1][w-K[i]]);
					} else {
						D[i][w] = D[i-1][w];
					}
				}
			}
			sb.append("#").append(t).append(" ").append(D[N][L]).append("\n");
		}
		System.out.print(sb);
	}
}
