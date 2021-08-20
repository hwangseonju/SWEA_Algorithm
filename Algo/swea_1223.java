import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
 
public class Solution {
 
    static int T = 10; // 테스트 케이스
    static int N; // 테스트 케이스 길이
    static Queue<Integer> queue = new LinkedList<Integer>(); // 데이터 담을 list
    static Stack<Integer> stack = new Stack<Integer>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 계산기2
        for (int t = 1; t <= T; t++) { // 테스트 케이스만큼 실행
            N = Integer.parseInt(br.readLine());
            String str = br.readLine();
 
            for (int n = 0; n < N; n++) {
                int temp = str.charAt(n) - '0';
                Postfixnotation(temp);
            }
             
            while(!stack.isEmpty()) {       // 스택에 남은 연산자 모두 빼기
                queue.offer(stack.pop());
            }
             
            while (!queue.isEmpty()) {  // 후위 표기식 계산
                int qout = queue.poll();
                 
                if(qout > -1) {  // 숫자일 경우
                    stack.push(qout);
                } else if(qout==-6){    // 곱하기 연산자
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(x*y);
                } else if(qout==-5) {   // 더하기 연산자
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(x+y);
                }
            }
             
            sb.append("#").append(t).append(" ").append(stack.pop()).append("\n");
        }
        System.out.print(sb);
    }
 
    static void Postfixnotation(int n) {    // 후위 표기법으로 생성
        if (n > -1) { // 숫자일 경우
            queue.offer(n);
        } else { // 숫자가 아닐 경우(*,+)
            if (stack.isEmpty()) {
                stack.push(n);
            } else {
                if (stack.peek() > n) {
                    stack.push(n);
                } else {
                    queue.offer(stack.pop());
                    Postfixnotation(n);
                }
            }
        }
        return;
    }
}