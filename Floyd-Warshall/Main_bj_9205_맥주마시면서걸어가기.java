
import java.io.*;
import java.util.*;

public class Main_bj_9205_맥주마시면서걸어가기 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder out = new StringBuilder();
	private static StringTokenizer st;
	
	private static final int MAX_N = 100;
	
	private static int n;
	private static short[] x, y;
	private static boolean[] visited;
	
	static {
		x = new short[MAX_N + 2];
		y = new short[MAX_N + 2];
		visited = new boolean[MAX_N + 2];
	}
	
	private static void init() throws IOException {
		n = Integer.parseInt(br.readLine().trim());
		for(int i = 0 ; i < n + 2 ; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			x[i] = Short.parseShort(st.nextToken());
			y[i] = Short.parseShort(st.nextToken());
		}
		Arrays.fill(visited, 0, n + 2, false);
	}
	
	private static Queue<Integer> q = new ArrayDeque<Integer>(MAX_N + 2);
	private static boolean bfs() {
		q.clear();
		q.offer(0);
		visited[0] = true;
		while(!q.isEmpty()) {
			int i = q.poll();
			for(int j = 0 ; j < n + 2 ; j++) {
				if(visited[j]) continue;
				if(Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]) <= 1000) {
					if(j == n + 1) return true;
					q.offer(j);
					visited[j] = true;
				}
			}
		}
		return false;
	}
	
	private static boolean dfs(int i) {
		visited[i] = true;
		for(int j = 0 ; j < n + 2 ; j++) {
			if(visited[j]) continue;
			if(Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]) <= 1000) {
				if(j == n + 1) return true;
				if(dfs(j)) return true;
			}
		}
//		visited[i] = false;
		return false;
	}
	
	private static boolean[][] reachable = new boolean[MAX_N + 2][MAX_N + 2];
	private static boolean floydwarshall() {
		
		for(int i = 0 ; i < n + 2 ; i++)
			for(int j = 0 ; j < n + 2 ; j++)
				if(Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]) <= 1000)
					reachable[i][j] = true;
				else
					reachable[i][j] = false;
		
		for (int k = 0; k < n + 2; k++) {
		    for (int i = 0; i < n + 2; i++) {
		        for (int j = 0; j < n + 2; j++) {
		            if (reachable[i][k] && reachable[k][j]) {
		                reachable[i][j] = true;
		            }
		        }
		    }
		    if(reachable[0][n+1]) return true;
		}
		return false;
	}
	
	private static void run() throws Exception {
		init();
		out.append(floydwarshall() ? "happy" : "sad").append("\n");
	}
	
	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine().trim());
		for(int tc = 1 ; tc <= TC ; tc++) {
			run();
		}
		System.out.print(out);
		br.close();
	}

}
