import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2805_2 {

	static int T; // 테스트케이스
	static int N; // 농장 크기
	static int[][] farm;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 농작물 수확하기(다시 풀기1)
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());

			farm = new int[N][N];
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < N; c++) {
					farm[r][c] = str.charAt(c) - '0';
				}
			}

			int sum=0;		// 수확할 농작물 
			int half = N/2;
			
			// 농작물 수확하기
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					int result = Math.abs(half-r) + Math.abs(half-c);	// 농장 중앙좌표와 현재 위치의 차이가 half 범위 안에만 있으면 수확가능
					if(result<=half) {
						sum+=farm[r][c];
					}
				}
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.print(sb);
	}
}
