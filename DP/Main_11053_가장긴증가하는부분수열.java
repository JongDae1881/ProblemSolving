package DP;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열 {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder out = new StringBuilder();
	
	static int[] seq;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine().trim());
		seq = new int[N];
		dp  = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0 ; i < N ; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for (int i = 0 ; i < N ; i++) {
			dp[i] = 1;
			for (int j = 0 ; j < i ; j++) {
				if (seq[j] < seq[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				
			}
			ans = dp[i] > ans ? dp[i] : ans;
		}
		
		out.append(ans);
		System.out.print(out.toString());
		br.close();
	}
	
}
