import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea_1228 {

	static int T = 10;
	static int N;
	static int D;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 암호문1
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 원문 암호문 길이
			st = new StringTokenizer(br.readLine(), " ");
			LinkedList<Integer> list = new LinkedList<>();
			for (int n = 0; n < N; n++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			D = Integer.parseInt(br.readLine()); // 명령어 개수
			st = new StringTokenizer(br.readLine(), " ");

			while (D-->0) {
				st.nextToken();	// I 버리기
				int x = Integer.parseInt(st.nextToken()); // 삽입 위치
				int y = Integer.parseInt(st.nextToken()); // 삽입할 개수
				for (int i = 0; i<y; i++) {	// 삽입될때의 다음 인덱스에 넣어줘야 연속으로 삽입됨
					list.add(x+i, Integer.parseInt(st.nextToken()));
				}
			}

			sb.append("#").append(t).append(" ");
			for (int p = 0; p < 10; p++) {
				sb.append(list.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
