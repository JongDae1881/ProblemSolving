package UnionFind;

import java.io.*;
import java.util.*;

public class Solution_d4_3289_서로소집합 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder out = new StringBuilder();
	private static StringTokenizer st;
	
	private static int N, M;
	private static int[] disjoint;
	
	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		disjoint = new int[N+1];
		for (int i = 1 ; i <= N ; i++) disjoint[i] = i;
	}
	
	private static int find(int i) {
		if(disjoint[i] == i) return i;
		return disjoint[i] = find(disjoint[i]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) {
			return false;
		} else {
			disjoint[bRoot] = aRoot;
			return true;
		}
	}
	
	private static void compute(int tc) throws IOException {
		out.append("#").append(tc).append(" ");
		while(M-->0) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int q = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (q == 0) {
				union(a, b);
			} else {
				if(find(a)==find(b)) out.append(1);
				else out.append(0);
			}
		}
		out.append('\n');
	}
	
	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1 ; tc <= TC ; tc++) {
			init();
			compute(tc);
		}
		System.out.print(out);
		br.close();
	}

}
