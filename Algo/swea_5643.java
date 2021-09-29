package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5643 {

	static int T;	// 테스트 케이스
	static int N;	// 학생수
	static int M;	// 비교 횟수
	static ArrayList<ArrayList<Integer>> go;	// 정방향(in)
	static ArrayList<ArrayList<Integer>> reverse;	// 역방향(out)
	static int[] inout;		// in-out 횟수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 키 순서
		T = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			
			go = new ArrayList<>();
			reverse = new ArrayList<>();
			inout = new int[N+1];
			
			for(int c=0; c<=N; c++) {	// 리스트 안에 리스트 추가
				go.add(new ArrayList<>());
				reverse.add(new ArrayList<>());
			}
			
			for(int i=0; i<M; i++) {	// a가 일치한 b들을 추가
				st = new StringTokenizer(br.readLine().trim());
				
				int S = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				
				go.get(S).add(L);
				reverse.get(L).add(S);
			}
			
			Count(go);
			Count(reverse);
			
			int total = 0;	// 자신의 키 순서를 아는 학생 수
			for(int io=0; io<=N; io++) {
				if(inout[io]-2==N-1) {	// 자신이 in, out에 1번씩 들어가기 때문에 -2를 해준 값에서 비교
					total++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(total).append("\n");
		}
		System.out.print(sb);
	}
	
	// in, out한 자식들 세기
	static void Count(ArrayList<ArrayList<Integer>> list) {
		for(int i=1; i<=N; i++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[N+1];
			
			queue.offer(i);
			
			while(!queue.isEmpty()) {
				int current = queue.poll();
				int size = list.get(current).size();
				
				if(!visited[current]) {	// 방문하지않은 자식들만 세기
					visited[current] = true;
					inout[i]++;
					
					for(int j=0; j<size; j++) {
						queue.offer(list.get(current).get(j));
					}
				}
			}
		}
	}

	static class LinkNode{
		int a;
		LinkNode pre;
		
		public LinkNode(int a, LinkNode pre) {
			super();
			this.a = a;
			this.pre = pre;
		}
	}
}
