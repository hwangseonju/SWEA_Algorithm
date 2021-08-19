import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class swea_2072 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 홀수만 더하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());	// 테스트케이스 수
        int t=0;
        
        // 입력받은 테스트케이스만큼 실행하기
        for (t = 1; t <= T; t++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            int num = 0;	// 입력받은 수
            int sum = 0;	// 홀수만 더한 총합
            
            // 10개의 수만큼 실행
            for (int i = 0; i < 10; i++) {
                num = Integer.parseInt(st.nextToken());
                
                // 홀수일 경우만 더해주기
                if (num % 2 == 1) {	
                    sum += num;
                }
            }
            System.out.println("#"+t+ " " + sum);
        }
    }
}