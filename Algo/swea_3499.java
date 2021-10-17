package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_3499 {

	static int T;
	static int N;
	static String[] str;
	static int half;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static Queue<String> q = new LinkedList<String>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 퍼펙트 셔플
		T = Integer.parseInt(br.readLine()); // 테스트 케이스
		for (int t = 1; t < T + 1; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			str = new String[N];
			for (int i = 0; i < N; i++) {
				str[i] = st.nextToken();
			}
			if (N % 2 == 0)
				half = N / 2; // 배열 중간 index 구하기
			else
				half = (N + 1) / 2;

			for (int j = 0; j < half; j++) {	// 교차로 큐에 데이터 넣기
				q.offer(str[j]);
				if (half + j < N) {
					q.offer(str[half + j]);
				}
			}

			sb.append("#").append(t).append(" ");
			while (!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}

}
