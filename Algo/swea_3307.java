import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3307 {

	static int T;	// 테스트케이스
	static int N;	// 수열의 길이
	static int[] num;	// 수열의 원소
	static int[] lis;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 최장 증가 부분 수열
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			lis = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int n=0; n<N; n++) {
				num[n] = Integer.parseInt(st.nextToken());
			}
			
			int max = Integer.MIN_VALUE;	// 최장 길이
			for(int i = 0; i < lis.length; i++) {
				lis[i] = 1;
				for(int j = 0; j < i; j++) {
					if(num[i] >= num[j] && lis[j] + 1 > lis[i]) lis[i] = lis[j] + 1;
				}
				max = Math.max(max, lis[i]);
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
	}

}
