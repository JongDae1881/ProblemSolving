package UnionFind;

import java.io.*;
import java.util.*;

public class Solution_d4_7465_창용마을무리의개수 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder out = new StringBuilder();
	private static StringTokenizer st;
	
	private static int N, M;
	private static int[] parent;
	
	private static int find(int a) {
		if(parent[a]==a) return a;
		else return parent[a] = find(parent[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		else {
			parent[bRoot] = aRoot;
			return true;
		}
	}
	
	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for (int i = 1 ; i <= N ; i++) parent[i] = i;
	}
	
	private static void compute(int tc) throws IOException {
		while (M --> 0) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		Set<Integer> rootSet = new HashSet<Integer>();
		for (int i  = 1 ; i <= N ; i++) {
			rootSet.add(find(i));
		}
		out.append("#").append(tc).append(" ").append(rootSet.size()).append("\n");
	}
	
	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine().trim());
		for (int tc = 1 ; tc <= TC ; tc++) {
			init();
			compute(tc);
		}
		System.out.print(out);
		br.close();
	}

}
