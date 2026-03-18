package DP;

import java.io.*;

public class Main_10422_괄호 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder out = new StringBuilder();
	
	static int N;
	static int[][] cachedValue;
	static boolean[][] isCached;
	static final int MOD = 1_000_000_007;
	
	static {
		cachedValue = new int[5001][5001];
		isCached = new boolean[5001][5001];
		cachedValue[2][0] = 1;
		isCached[2][0] = true;
	}
	
	static int gwalho(int n, int r) {
		if(n==r)
			return 1;
		if(r < 0)
			return 0;
		if(n < r)
			return 0;
		
		if(isCached[n][r])
			return cachedValue[n][r];
		
		cachedValue[n][r] = ( gwalho(n-1,r-1)+gwalho(n-1,r+1) ) % MOD;
		isCached[n][r] = true;
		return cachedValue[n][r];
	}

	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine().trim());
		while(TC-->0) {
			N = Integer.parseInt(br.readLine().trim());
			out.append(gwalho(N, 0)).append('\n');
		}
		System.out.print(out);
		br.close();
	}

}
