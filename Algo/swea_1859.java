package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1859 {
	
	static int T;	// 테스트 케이스
	static int N;	// 연속된 일수
	static int[] days;	// 매매가
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 백만장자 프로젝트

		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");

			days = new int[N];
			for(int n=0; n<N; n++) {
				days[n] = Integer.parseInt(st.nextToken());
			}
			
			int max = days[N-1];
			long result = 0;
			for(int n=N-2; n>=0; n--) {
				if(max<days[n]) {
					max=days[n];
				}else {
					result += max - days[n];
				}
			}
				
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}
}
