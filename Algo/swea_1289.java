import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class swea_1289 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 원재의 메모리 복구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        int t = 0;
 
        for (t = 1; t <= T; t++) {
            String line = br.readLine();
            int[] num = new int[line.length()];
            int result = 0;
            for (int i = 0; i < num.length; i++) {
                num[i] = line.charAt(i) - '0';
            }
 
            for (int i = 0; i < num.length; i++) {
                if (num[i] == 1) {
                    for (int j = i; j <= num.length - 1; j++) {  //1인 부분부터 끝까지 값 바꾸기
                        if (num[j] == 0) {
                            num[j] = 1;
                        } else {
                            num[j] = 0;
                        }
                    }
                    result++;   // 변경한 횟수 count한 결과값
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}