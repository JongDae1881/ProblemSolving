import java.io.*;
import java.util.*;

public class Main {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder out = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, X;
	static List<int[]>[] G;
	static List<int[]>[] reverseG;
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		G = new List[N+1];
		reverseG = new List[N+1];
		for(int i = 1 ; i <= N ; i++) {
			G[i] = new ArrayList<>();
			reverseG[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			G[from].add(new int[] {to, cost});
			reverseG[to].add(new int[] {from, cost});
		}
	}
	
	static int[] dijsktra(List<int[]>[] graph, int start) {
		int[] dist = new int[N+1]; Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[1], b[1]));
		dist[start] = 0;
		pq.offer(new int[] {start, 0});
		while(!pq.isEmpty()) {
			int[] e = pq.poll();
			int vertex = e[0];
			int cost = e[1];
			if(dist[vertex] < cost) continue;
			for(int[] j : graph[vertex]) {
				int nVertex = j[0];
				int nCost = j[1];
				if(dist[nVertex] > cost + nCost) {
					dist[nVertex] = cost + nCost;
					pq.offer(new int[] {nVertex, dist[nVertex]});
				}
			}
		}
		return dist;
	}
	
	static void compute() {
		int[] costGo = dijsktra(reverseG, X);
		int[] costBack = dijsktra(G, X);
		int ans = 0;
		for(int i = 1 ; i <= N ; i++) {
			int time = costGo[i] + costBack[i];
			if(ans < time) 
				ans = time;
		}
		out.append(ans).append("\n");
	}
	
	public static void main(String[] args) throws Exception {
		init();
		compute();
		
		System.out.print(out);
		br.close();
	}
}