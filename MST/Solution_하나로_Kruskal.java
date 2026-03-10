
import java.io.*;
import java.util.*;

public class Solution_하나로_Kruskal {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder out = new StringBuilder();
	private static StringTokenizer st;
	
	private static int N;
	private static int[][] island;
	private static double rate;
	
	private static Edge[] edgeList;
	private static int[] parent;
	
	static class Edge implements Comparable<Edge> {
		int start, end;
		long weight;

		private Edge(int start, int end, long weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
		
	}
	
	
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		island = new int[N][2];
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0 ; i < N ; i++) {
			island[i][0] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0 ; i < N ; i++) {
			island[i][1] = Integer.parseInt(st.nextToken());
		}
		rate = Double.parseDouble(br.readLine().trim());
		makeEdge();
	}
	
	private static void makeEdge() {
		edgeList = new Edge[N*(N-1)/2];
		int idx = 0;
		for (int i = 0 ; i < N - 1 ; i++) {
			for (int j = i + 1 ; j < N ; j++) {
				long weight = (long) (island[i][0] - island[j][0]) * (island[i][0] - island[j][0])
						  + (long) (island[i][1] - island[j][1]) * (island[i][1] - island[j][1]);
				edgeList[idx++] = new Edge(i, j, weight);
			}
		}
	}
	
	private static void makeSet() {
		parent = new int[N];
		for(int i = 0 ; i < N ; i++) parent[i] = i;
	}
	
	private static int findSet(int a) {
		if(parent[a] == a) return a;
		return parent[a] =  findSet(parent[a]);
	}
	
	private static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parent[bRoot] = aRoot;
		return true;
	}
	
	private static void compute(int tc) {
		Arrays.sort(edgeList);
		long mst = 0;
		int cnt = 0;
		makeSet();
		for(Edge e : edgeList) {
			if(unionSet(e.start, e.end)) {
				mst += e.weight;
				if(++cnt==N) break;
			}
		}
		out.append('#').append(tc).append(' ').append(Math.round(mst * rate)).append('\n');
	}
	
	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine().trim());
		for (int tc = 1 ; tc <= TC; tc++) {
			init();
			compute(tc);
		}
		System.out.print(out);
		br.close();
	}

}
