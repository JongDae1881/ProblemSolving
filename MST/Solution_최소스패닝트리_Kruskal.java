import java.io.*;
import java.util.*;

public class Solution_최소스패닝트리_Kruskal {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder out = new StringBuilder();
	private static StringTokenizer st;
	
	private static int V, E;
	private static Edge[] edgeList;
	private static int[] parents;
	
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static void makeSets() {
		parents = new int[V + 1];
		for (int i = 1 ; i <= V ; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a]==a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		for (int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, weight);
		}
	}
	
	static void compute(int tc) {
		Arrays.sort(edgeList);
		makeSets();
		int cnt = 0;
        long mst = 0;
		for (Edge edge : edgeList) {
			if(unionSet(edge.start, edge.end)) {
				mst += edge.weight;
				if(++cnt == V) break;
			}
		}
		out.append('#').append(tc).append(' ').append(mst).append('\n');
	}
	
	public static void main(String[] args) throws Exception {
		final int TC = Integer.parseInt(br.readLine().trim());
		for (int tc = 1 ; tc <= TC ; tc++) {
			init();
			compute(tc);
		}
		System.out.print(out);
		br.close();
	}

}
