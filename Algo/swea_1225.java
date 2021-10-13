
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1225 {

	static int T; // 테스트 케이스
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static Queue<Integer> queue = new LinkedList<Integer>();
	static int temp = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 암호 생성기
		for (int t = 0; t < 10; t++) {
			T = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			outer: while (true) {
				for (int i = 1; i < 6; i++) {
					temp = queue.poll() - i;
					if (temp <= 0) {
						temp = 0;
						queue.offer(temp);
						break outer;
					} else {
						queue.offer(temp);
					}
				}
			}
			
			sb.append("#").append(T).append(" ");
			while(!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
