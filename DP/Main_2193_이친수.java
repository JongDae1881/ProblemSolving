package DP;

import java.util.Scanner;

public class Main_2193_이친수 {
	
	static final int MAX_N = 90;
	static long[] pinary;
	static boolean[] isCached;
	
	static {
		pinary = new long[MAX_N + 1];
		isCached = new boolean[MAX_N + 1];
		pinary[0] = pinary[1] = 1;
		isCached[0] = isCached[1] = true;
	}

	static long calPinary(int n) {
		if(isCached[n])
			return pinary[n];
		
		for(int i = 0 ; i <= n-2; i++)
			pinary[n] += calPinary(i);
		isCached[n] = true;
		
		return pinary[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(calPinary(n));
		sc.close();
	}

}
