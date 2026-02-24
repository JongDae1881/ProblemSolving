package DP;

import java.io.*;

public class Main_24416_알고리즘수업피보나치수1 {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder out = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine().trim());
		out.append(fib(n)+" "+(n-2));
		System.out.print(out.toString());
		br.close();
	}

	static int fib(int n) {
		if (n == 1 || n == 2)
			return 1;
		return fib(n-1) + fib(n-2);
	}
}
