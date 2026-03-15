package DP;

import java.io.*;
import java.util.*;

public class Main_9465_스티커 {
	
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder out = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static int[][] score;
	static int[][] dp;
	static boolean[][] isCached;
	static final int MAX_N = 100_000;
	static final int NONE = 0;
	static final int TOP = 1;
	static final int BOTTOM = 2;
	
	static int getMaxScore(int column) {
		return Math.max(Math.max(getScore(0, column), getScore(1, column)), getScore(2, column));
	}
	
	static int getScore(int state, int column) {
		if(isCached[state][column]) 
			return dp[state][column];
		
		if(state==NONE)
			dp[state][column] = getMaxScore(column - 1);
		else if(state==TOP)
			dp[state][column] = Math.max(getScore(NONE, column-1), getScore(BOTTOM, column-1)) + score[TOP][column];
		else // if(state==BOTTOM)
			dp[state][column] = Math.max(getScore(NONE, column-1), getScore(TOP, column-1)) + score[BOTTOM][column];
		
		isCached[state][column] = true;
		return dp[state][column];
	}
	
	static {
		score = new int[3][MAX_N + 1];
		dp = new int[3][MAX_N + 1];
		isCached = new boolean[3][MAX_N + 1];
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		for(int state = 1 ; state <= 2 ; state++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int column = 1 ; column <= N ; column++) {
				score[state][column] = Integer.parseInt(st.nextToken());
			}
		}
		for(int state = 0 ; state <= 2 ; state++) Arrays.fill(isCached[state], false);
		for(int state = 0 ; state <= 2 ; state++) {
			dp[state][1] = score[state][1];
			isCached[state][1] = true;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine().trim());
		while(TC-->0) {
			init();
			out.append(getMaxScore(N)).append("\n");
		}
		System.out.print(out);
		br.close();
	}

}
