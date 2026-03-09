package MST;

import java.io.*;
import java.util.*;

public class Main_1922_네트워크연결 {
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int V, E;
	private static List<int[]>[] G;
	
	private static void init() throws IOException {
		V = Integer.parseInt(br.readLine().trim());
		E = Integer.parseInt(br.readLine().trim());
		G = new List[V+1]; for (int i = 1 ; i <= V ; i++) G[i] = new ArrayList<int[]>();
		for (int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			G[a].add(new int[] {b, c});
			G[b].add(new int[] {a, c});
		}
	}
	
	private static int prim() {
		int[] P = new int[V+1]; Arrays.fill(P, Integer.MAX_VALUE);
		int mst = 0, cnt = 0;
		boolean[] v = new boolean[V+1];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->Integer.compare(a[1], b[1]));
		P[1] = 0;
		pq.offer(new int[] {1, P[1]});
		while(!pq.isEmpty()) {
			int[] vc = pq.poll();
			int minVertex = vc[0];
			int min = vc[1];
			if(v[minVertex]) continue;
			v[minVertex] = true;
			mst += min;
			if(++cnt==V) break;
			for(int[] j : G[minVertex]) {
				if(!v[j[0]] && P[j[0]] > j[1]) {
					P[j[0]] = j[1];
					pq.offer(new int[] {j[0], j[1]});
				}
			}
		}
		return mst;
	}

	public static void main(String[] args) throws Exception{
		init();
		System.out.println(prim());
	}

}
