package DP;

import java.io.*;
import java.util.*;

public class Main_2294_동전2_top_down {
	
	static int N, K;
	static Set<Integer> coins;
	static int dp[];
	static boolean[] isCached;
	static int minCoin;
	static final int INF = 100001;
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coins = new HashSet<Integer>();
		dp = new int[K+1];
		isCached = new boolean[K+1];
		for(int n = 1 ; n <= N ; n++) { 
			int coin = Integer.parseInt(br.readLine().trim());
			coins.add(coin);
		}
		br.close();
		minCoin = Collections.min(coins);
	}
	
	static int solve(int k) {
		if(k < minCoin)
			return INF;
		if(isCached[k])
			return dp[k];
		if(coins.contains(k))
			return 1;
		
		int minimum = INF;
		for(int coin : coins)
			minimum = Math.min(minimum, solve(k-coin) + 1);
		dp[k] = minimum;
		
		isCached[k] = true;
		return dp[k];
	}
	
	public static void main(String[] args) throws Exception {
		init();
		int ans = solve(K);
		System.out.println(ans != INF ? ans : -1);
	}

}
