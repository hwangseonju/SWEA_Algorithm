import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1861 {

	static int T;
	static int N;
	static int[][] num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 정사각형 방
		T = Integer.parseInt(br.readLine()); // 테스트 케이스
		for (int t = 1; t < T + 1; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N][N]; // N^2개의 방
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					num[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			int room = 0; // 이동 횟수가 많은 방
			int moveroom = 0; // 이동 횟수
			int temp = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					temp = findRoom(r, c);
					if (moveroom <= temp) {
						if(moveroom==temp) {	// 이동 횟수가 같을경우 더 작은 방 숫자를 저장
							room = room<num[r][c]? room:num[r][c];
						}else {
							moveroom = temp;
							room = num[r][c];
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(room).append(" ").append(moveroom + 1).append("\n");
		}
		System.out.println(sb);
	}

	static int[][] deltas = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
	private static int findRoom(int r, int c) { // 이동 횟수 찾기
		int count = 0;

		outer: while (true) {
			for (int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];

				if (isIn(nr, nc) && num[nr][nc] - num[r][c] == 1) {
					r = nr;
					c = nc;
					count++; // 현재방보다 이동할 방의 숫자가 1 클 경우
					continue outer;
				}
			}
			break;
		}
		return count;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
