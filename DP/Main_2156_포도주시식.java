package DP;

import java.io.*;

public class Main_2156_포도주시식 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder out = new StringBuilder();
	
	private static int N;
	private static int[] seq;
	
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		seq = new int[N + 1];
		for (int i = 1 ; i<= N ; i++)
			seq[i] = Integer.parseInt(br.readLine().trim());
	}
	
	private static void compute() {
		int[][] dp = new int[N + 1][3];
		dp[1][1] = seq[1];
		// dp[i][0] : i번째 잔을 마시지 않은 경우 (이전 상태 무관)
		// dp[i][1] : i-1번째 잔을 마시지 않고, i번째와 i-2번째 잔을 마신 경우
		// dp[i][2] : i-2번째 잔을 마시지 않고, i번째와 i-1번째 잔을 마신 경우
		for (int i = 2 ; i <= N ; i++) {
			dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
			dp[i][1] = dp[i-1][0] + seq[i];
			dp[i][2] = dp[i-1][1] + seq[i];
		}
		out.append(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])));
	}
	
	public static void main(String[] args) throws Exception {
		init();
		compute();
		System.out.print(out);
		br.close();
	}

}
