
import java.io.*;
import java.util.*;

public class Solution_d4_5643_키순서_HW {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder out = new StringBuilder();
	private static StringTokenizer st;
	
	private static final int MAX_N = 500;
	private static int N, M;
	private static boolean[][] reachable;
	
	static {
		reachable = new boolean[MAX_N + 1][MAX_N + 1];
	}
	
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		for(int i = 1 ; i <= N ; i++)
			Arrays.fill(reachable[i], 1, N + 1, false);
		M = Integer.parseInt(br.readLine().trim());
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			reachable[from][to] = true;
		}
	}
	
	
	private static void floydwarshall() {
		for(int k = 1 ; k <= N ; k++)
			for(int i = 1 ; i <= N ; i++) {
				if(!reachable[i][k]) continue;
				for(int j = 1 ; j <= N ; j++)
					if(reachable[k][j])
						reachable[i][j] = true;
			}
	}
	
	private static int calculateAnswer() {
		int ans = 0;

		for(int i = 1 ; i <= N ; i++) {
			int cnt = 0;
			
			for(int j = 1 ; j <= N ; j++)
				if(reachable[i][j] || reachable[j][i])
					cnt++;
			
			if(cnt == N-1)
				ans++;
		}
		
		return ans;
	}
	
	private static void run(int tc) throws Exception {
		init();
		floydwarshall();
		out.append("#").append(tc).append(" ").append(calculateAnswer()).append("\n");
	}
	
	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine().trim());
		for(int tc = 1 ; tc <= TC ; tc++)
			run(tc);
		System.out.print(out);
		br.close();
	}

}
