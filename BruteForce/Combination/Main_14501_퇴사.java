import java.io.*;
import java.util.*;

public class Main_14501_퇴사 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] T, P;
	static int ans;
	
	static void skipComb(int startDate, int sum) {
		if(startDate >  N + 1) return;
		for(int date = startDate ; date <= N ; date++) {
			if(date + T[date] <= N + 1) ans = Math.max(ans, sum + P[date]);
			skipComb(date+T[date], sum + P[date]);
		}
	}

	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		T = new int[N+1];
		P = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		skipComb(1, 0);
		System.out.println(ans);
		br.close();
	}

}
