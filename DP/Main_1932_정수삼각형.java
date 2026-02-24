package DP;

import java.io.*;
import java.util.*;

public class Main_1932_정수삼각형 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder out = new StringBuilder();
	private static StringTokenizer st;
	
	private static int N;
	private static int[][] triangle;
	
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		triangle = new int[N+1][N+1];
		for (int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 1 ; j <= i ; j++)
				triangle[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		int[][] dp = new int[N+1][N+1];
		int ans = Integer.MIN_VALUE;
		for (int i = N - 1 ; i <= N ; i++) {
			for (int j = 1 ; j <= i ; j++) {
				dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
				ans = dp[i][j] > ans ? dp[i][j] : ans;
			}
		}
		out.append(ans);
		System.out.print(out.toString());
		br.close();
	}

}
