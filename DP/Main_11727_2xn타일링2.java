package DP;

import java.io.*;

public class Main_11727_2xn타일링2 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder out = new StringBuilder();

	private static int n; // n <= 1_000
	
	private static void init() throws IOException {
		n = Integer.parseInt(br.readLine().trim());
	}
	
	private static void compute() {
//		int dp[] = new int[Math.max(n + 1, 2 + 1)];
//		dp[1] = 1;
//		dp[2] = 3;
//		for (int i = 3 ; i <= n ; i++) {
//			dp[i] = ( dp[i - 1] + dp[i - 2] * 2 ) % 10_007;
//		}
		
		int dp_prev = 1;
		int dp = 1;
		for (int i = 1 ; i < n ; i++) {
			int temp = dp;
			dp = ( dp + dp_prev * 2 ) % 10_007; // 정수론 입문에 대해 간단하게 복습할 필요 있을 듯
			dp_prev = temp;
		}
		
		
		out.append(dp);
	}
	
	public static void main(String[] args) throws Exception {
		init();
		compute();
		System.out.print(out);
		br.close();
	}

}
