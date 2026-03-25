package DisjointSets;
import java.io.*;
import java.util.*;
public class Main_1717_집합의표현 {

	static int N, M;
	static int[] representative;
	
	static void init() {
		representative = new int[N+1];
		for(int i = 0 ; i <= N ; i++)
			representative[i] = i;
	}
	
	static int find(int x) {
		if(representative[x] == x)
			return x;
		return representative[x] = find(representative[x]);
	}
	
	static boolean union(int x, int y) {
		int representativeOfx = find(x);
		int representativeOfy = find(y);
		if(representativeOfx == representativeOfy)
			return false;
		representative[representativeOfy] = representativeOfx;
		return true;
	}
	
	static String check(int x, int y) {
		int representativeOfx = find(x);
		int representativeOfy = find(y);
		if(representativeOfx == representativeOfy)
			return "YES\n";
		else
			return "NO\n";
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		init();
		while(M-->0) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int query = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(query == 0) 
				union(a, b);
			if(query == 1)
				out.append(check(a, b));
		}
		
		System.out.print(out);
		br.close();
	}

}
