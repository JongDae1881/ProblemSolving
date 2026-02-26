package DP;

import java.io.*;
import java.util.*;

public class Main_1912_부분합 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder out = new StringBuilder();
	private static StringTokenizer st;
	
	private static int N;
	private static int[] seq;
	
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		seq = new int[N];
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0 ; i < N ; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	
	/*
	 * dp[i] for 0 <=0 < N-1의 의미는 seq[i]를 마지막으로 하는 연속되는 부분 수열의 최대합을 담는다.
	 * 즉, 앞서 구한 연속합(i-1번째 항을 마지막 피연산자로 하는 최대 합)에 seq[i]를 더한 게 더 큰지,
	 * 아니면 seq[i]만 취하는 게 더 큰지를 비교함으로써 dp[i]를 구한다.
	 * dp[i]를 현재까지 계산한 연속 부분 수열의 최대 합이라고 해서 구하기에는 어려울 것이다.
	 * 왜냐하면 dp라는 변수를 그런 식으로 정의할 경우, "연속"이라는 속성이 값에 담겨 있지 않기 때문이다.
	 * 예를 들어, 4번째 항까지 봤을 때 합이 최대가 되는 경우는 1~3번째 항까지의 합이라고 하자.
	 * 그러면 5번째 항을 고려할 때 이 값이 5번째 항과 함께 연속해서 더해지는 값인지 아닌지 알 수가 없다.
	 */
	private static void compute() {
		int dp = seq[0];
		int ans = dp;
		for (int i = 1 ; i < N ; i++) {
			dp = Math.max(dp + seq[i], seq[i]);
			ans = Math.max(ans, dp);
		}
		out.append(ans);
	}
	
	public static void main(String[] args) throws Exception {
		init();
		compute();
		System.out.print(out);
		br.close();
	}

}
