package DP;

import java.io.*;
import java.util.*;

public class Main_12865_평범한배낭 {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder out = new StringBuilder();
	static StringTokenizer st;
	
	static int N, K;
	static int[][] WV;
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		WV = new int[N+1][2];
		for (int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			WV[i][0] = Integer.parseInt(st.nextToken());
			WV[i][1] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		int[][] dp = new int[K+1][N+1];
		
		// initial condition
		int k = 1;
		for (int n = 1 ; n <= N ; n++) {
			if (WV[n][0] > k)
				dp[k][n] = dp[k][n-1];
			else {
				dp[k][n] = Math.max(dp[k][n-1], WV[n][1]);
			}
		}
		// bottom-up tabulation
		for (k = 2 ; k <= K ; k++) {
			for (int n = 1 ; n <= N ; n++) {
				if (WV[n][0] > k) 
					dp[k][n] = dp[k][n-1];
				else
					dp[k][n] = Math.max(dp[k][n-1], dp[k - WV[n][0]][n - 1] + WV[n][1]);
			}
		}
		out.append(dp[K][N]);
		System.out.print(out.toString());
		br.close();
	}

}
