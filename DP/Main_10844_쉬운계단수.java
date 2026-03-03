package DP;

import java.io.*;

public class Main_10844_쉬운계단수 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[][] dp = new int[N+1][10];
		for (int i = 1 ; i <= 9 ; i++) dp[1][i] = 1;
		for (int i = 2 ; i <=N ; i++) {
			dp[i][1] = (dp[i][1] + dp[i-1][0]) % 1_000_000_000;
			dp[i][8] = (dp[i][8] + dp[i-1][9]) % 1_000_000_000;
			for (int j = 1 ; j <= 8 ; j++) {
				dp[i][j-1] = (dp[i][j-1] + dp[i-1][j]) % 1_000_000_000;
				dp[i][j+1] = (dp[i][j+1] + dp[i-1][j]) % 1_000_000_000;
			}
		}
		int ans = 0;
		for (int i = 0 ; i < 10 ; i++) ans = (ans + dp[N][i]) % 1_000_000_000;
		System.out.println(ans);
		br.close();
	}

}
