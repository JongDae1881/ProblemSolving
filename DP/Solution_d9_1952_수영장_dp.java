package HW0406;

import java.io.*;
import java.util.*;

public class Solution_d9_1952_수영장_dp {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder out = new StringBuilder();
	private static StringTokenizer st;
	
	public static int[] dp;
	public static boolean[] isCached;
	public static int[] fee;
	public static int[] numVisit;
	
	public static final int MAX_MONTH = 12;
	public static final int DAILY = 0;
	public static final int MONTHLY = 1;
	public static final int THREEMONTH = 2;
	public static final int YEARLY = 3;
	
	static {
		dp = new int[MAX_MONTH + 1];
		isCached = new boolean[MAX_MONTH + 1];
		fee = new int[4];
		numVisit = new int[MAX_MONTH + 1];
	}
	
	public static int solve(int month) {
		if(month <= 0) return 0;
		if(isCached[month]) return dp[month];
		
		dp[month] = solve(month - 1) + Math.min(fee[DAILY] * numVisit[month], fee[MONTHLY]);
		if(month >= 3)
			dp[month] = Math.min(dp[month], solve(month - 3) + fee[THREEMONTH]);
		isCached[month] = true;
		
		return dp[month];
	}
	
	public static void init() throws IOException {
		Arrays.fill(dp, 0);
		Arrays.fill(isCached, false);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < 4 ; i++) {
			fee[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= MAX_MONTH ; i++) {
			numVisit[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= TC ; tc++) {
			init();
			solve(MAX_MONTH);
			out.append("#").append(tc).append(" ").append(fee[YEARLY] <= dp[MAX_MONTH] ? fee[YEARLY] : dp[MAX_MONTH]).append("\n");
		}
		System.out.print(out);
		br.close();
	}

}
