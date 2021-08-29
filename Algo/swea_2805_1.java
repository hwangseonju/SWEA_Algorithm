import java.util.Scanner;
 
public class swea_2805_1 {
 
    public static void main(String[] args) {
        // 농작물 수확하기
        Scanner scan = new Scanner(System.in);
 
        int T = scan.nextInt(); // 테스트 케이스
         
        for (int t = 0; t < T; t++) {
            int N = scan.nextInt(); // 농장 크기
            int[][] num = new int[N][N];
            int sum = 0;	// 수확한 농작물
             
            for (int r = 0; r < N; r++) {
                String str = scan.next();
                for (int c = 0; c < N; c++) {
                    num[r][c] = str.charAt(c)-'0';
                }
            }
 
            int mid = N / 2;
            int start = mid;
            int finish = mid;
            
            // 상단 삼각형 더하기
            for (int r = 0; r <= N / 2; r++) {
                for (int c = start; c <= finish; c++) {
                    sum += num[r][c];
                }
                start--;
                finish++;
            }
             
            start +=2;
            finish -=2;
            
            // 하단 삼각형 더하기
            for (int r = (N/2)+1; r < N; r++) {
                for (int c = start; c <= finish; c++) {
                    sum += num[r][c];
                }
                start++;
                finish--;
            }
            System.out.println("#"+(t+1)+" "+ sum);
        }
    }
}