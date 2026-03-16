import java.io.*;
import java.util.*;

public class Main {
	
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, S;
	static int[] magicStone;
	
	static int subs() {
		int ans = 0;
		for(int i = 1 ; i < (1 << N) ; i++) {
			int sum = 0;
			for(int j = 0 ; j < N ; j++) {
				if( (i & (1<<j)) != 0) {
					sum += magicStone[j];
				}
			}
			if(sum == S)
				ans++;
		}
		return ans;
	}
	
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		magicStone = new int[N];
		st = new StringTokenizer(br.readLine().trim(), " ");
		for(int i = 0 ; i < N ; i ++) {
			magicStone[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(subs());
		br.close();
	}
}