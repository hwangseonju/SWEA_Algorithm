import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3124 {
	
	static int T;	// 테스트케이스
	static int V;	// 정점
	static int E;	// 간선
	static Edge[] list;
	static int[] parents;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 최소 스패닝 트리(Kruskal - 서로소)
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			list = new Edge[E];
			
			for(int e=0; e<E; e++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken())-1;	// 시작 정점
				int finish = Integer.parseInt(st.nextToken())-1;	// 끝 정점
				int weight = Integer.parseInt(st.nextToken());	// 가중치
				
				list[e] = new Edge(start, finish, weight);
			}
			
			Arrays.sort(list);
			
			makeSet();
			
			long result = 0;
			for (Edge e : list) {
				if(unionSet(e.s, e.f)) {
					result += e.w;
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}

		System.out.print(sb);
	}

	static void makeSet() {
		parents = new int[V];
		for(int i=0; i<V; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(x == parents[x])	return x;
		
		return parents[x] = findSet(parents[x]);
	}
	
	static boolean unionSet(int x, int y) {
		int xroot = findSet(x);
		int yroot = findSet(y);
		if(xroot == yroot)	return false;
		
		parents[yroot] = xroot;
		return true;
	}
	
	static class Edge implements Comparable<Edge> {
		int s, f, w;
		
		public Edge(int s, int f, int w) {
			super();
			this.s = s;
			this.f = f;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
}
