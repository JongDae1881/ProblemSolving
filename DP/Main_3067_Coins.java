package DP;

import java.io.*;
import java.util.*;

public class Main_3067_Coins {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder out = new StringBuilder();
	static StringTokenizer st;
	
	static final int MAX_N = 20, MAX_M = 10000;
	static int N, M;
	static int[] coins;
	static int[][] dp;
	static boolean[][] isCached;
	
	static int solve(int n, int m) {
		if(n < 0 || m < 0)
			return 0;
		if(m == 0)
			return 1;
		if(isCached[n][m])
			return dp[n][m];
		
		dp[n][m] = solve(n - 1, m) + solve(n, m - coins[n]);
		isCached[n][m] = true;
		return dp[n][m];
	}
	
	static {
		coins = new int[MAX_N];
		dp = new int[MAX_N][MAX_M + 1];
		isCached = new boolean[MAX_N][MAX_M + 1];
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim(), " ");
		for(int i = 0 ; i < N ; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine().trim());
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(dp[i], 0);
			Arrays.fill(isCached[i], false);
		}
	}
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		while(T --> 0) {
			init();
			out.append(solve(N - 1, M)).append("\n");
		}
		System.out.print(out);
		br.close();
	}

}
