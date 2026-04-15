import java.io.*;
import java.util.*;

public class Solution_d3_3282_01Knapsack_optimized {

	public static void main(String[] args) throws Exception {
		
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final StringBuilder out = new StringBuilder();
		StringTokenizer st;
		
		final int MAX_K = 1000;
		int[] dp = new int[MAX_K + 1];
		
		final int TC = Integer.parseInt(br.readLine().trim());
		for(int tc = 1 ; tc <= TC ; tc++) {
		
			st = new StringTokenizer(br.readLine().trim(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Arrays.fill(dp, 0);
			for(int n = 1 ; n <= N ; n++) {
				
				st = new StringTokenizer(br.readLine().trim(), " ");
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				for(int k = K ; k >= v ; k--) {
					dp[k] = Math.max(dp[k], dp[k - v] + c);
				}
			}
			
			out.append("#").append(tc).append(" ").append(dp[K]).append("\n");
		}
		
		System.out.print(out);
		br.close();
	}

}