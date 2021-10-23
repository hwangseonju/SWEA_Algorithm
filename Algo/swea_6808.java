import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_6808 {

	static int T;
	static int win;
	static int lose;
	static int[] G = new int[9];
	static int[] I = new int[9];
	static int[] choosed = new int[9];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 규영이와 인영이의 카드게임
		T = Integer.parseInt(br.readLine()); // 테스트 케이스
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			boolean[] all = new boolean[19];

			for (int g = 0; g < 9; g++) { // 규영이 카드
				G[g] = Integer.parseInt(st.nextToken());
				all[G[g]] = true;
			}

			for (int a = 1, i = 0; a < 19; a++) { // 인영이 카드
				if (all[a] == false) {
					I[i++] = a;
				}
			}
			win = 0;
			lose = 0;
			Permutation(9, choosed, new boolean[I.length]);
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}

	static void Permutation(int n, int[] choosed, boolean[] visited) { // 순열 - 인영이 카드
		if (n == 0) {
			int gsum = 0;
			int isum = 0;
			for (int p = 0; p < 9; p++) {
				if (G[p] > choosed[p]) {
					gsum += (G[p] + choosed[p]);
				} else {
					isum += (choosed[p] + G[p]);
				}
			}
			win += gsum>isum?1:0;	// 규영이가 이길 경우
			lose += gsum<isum?1:0;	// 규영이가 질 경우
			return;
		}
		for (int i = 0; i < I.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choosed[choosed.length - n] = I[i];
				Permutation(n - 1, choosed, visited);
				visited[i] = false;
			}
		}
	}
}