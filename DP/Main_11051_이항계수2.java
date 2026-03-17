package DP;

import java.util.Scanner;

public class Main_11051_이항계수2 {

	static int N, K;
	static int[][] dp;
	static boolean[][] isCached;
	
	static int nCk(int n, int k) {
		if(k==0) return 1;
		if(n==k) return 1;
		
		if(isCached[n][k])
			return dp[n][k];
		
		dp[n][k] = ( nCk(n-1,k) + nCk(n-1,k-1) ) % 10007;
		isCached[n][k] = true;
		return dp[n][k];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		dp = new int[N+1][K+1];
		isCached  = new boolean[N+1][K+1];
		System.out.println(nCk(N,K));
		sc.close();
	}

}
