package DP;

import java.io.*;
import java.util.*;

public class Main_2293_동전1_bottomup_io {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N+1];
		for(int i = 1 ; i <= N ; i++)
			coin[i] = Integer.parseInt(br.readLine().trim());
		
		int[] curr = new int[K+1];
		for(int k = 0 ; k <= K ; k += coin[1])
			curr[k] = 1;
//		System.out.println(Arrays.toString(curr));
		for(int i = 2 ; i <= N ; i++) {
			int[] next = new int[K+1];
			for(int k = 0 ; k <= K ; k++)
				for(int j = 0 ; j <= k/coin[i] ; j++)
					next[k] += curr[k - j*coin[i]];
			curr = next;
//			System.out.println(Arrays.toString(curr));
		}
		
		System.out.println(curr[K]);
	}

}
