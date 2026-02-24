package DP;

import java.io.*;
import java.util.*;

public class Main_12865_평범한배낭_TopDown {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder out = new StringBuilder();
	static StringTokenizer st;
	
	static int N, K;
	static int[] W, V;
	
	static Integer[][] dp;
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N + 1];
		V = new int[N + 1];
		for (int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		dp = new Integer[N + 1][K + 1];
	}
	
	static int knapsack(int n, int k) {
		// Memoization
		if (dp[n][k] != null) return dp[n][k].intValue();
		// Base part
		if (n < 1) return 0;
		// Inductive part
		if (k < W[n])
			dp[n][k] = knapsack(n - 1, k);
		else 
			dp[n][k] = Math.max(knapsack(n - 1, k), knapsack(n - 1, k - W[n]) + V[n]);
		return dp[n][k];
	}
	
	public static void main(String[] args) throws Exception {
		init();
		out.append(knapsack(N, K));
		System.out.print(out.toString());
		br.close();
	}

}
