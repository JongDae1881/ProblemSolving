import java.io.*;
import java.util.*;

public class Main_bj_11048_이동하기 {
	
	public static void main(String[] args) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[M];
		while(N-->0) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int i = 0 ; i < M ; i++) {
				int a_i = Integer.parseInt(st.nextToken());
				dp[i] = Math.max(i > 0 ? dp[i-1] : 0, dp[i]) + a_i;
			}
		}
		System.out.print(dp[M-1]);
	}

}