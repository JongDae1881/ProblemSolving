import java.io.*;
import java.util.*;

public class Solution_보급로 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder out = new StringBuilder();
	
	private static int N;
	private static final int[][] map = new int[100][100];
	private static final int[][] dijk = new int[100][100];
	private static final int[] dr = {-1, 0, 0, 1};
	private static final int[] dc = { 0,-1, 1, 0};
	private static final int INF = 10_00_00;
	
	private static class Node implements Comparable<Node> {
		int r, c, w;
		Node(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		for (int r = 0 ; r < N ; r++) {
			String line = br.readLine().trim();
			for (int c = 0 ; c < N ; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}
	}
	
	private static boolean inRange(int r, int c) {
		return 0 <= r&&r < N && 0 <= c&&c < N;
	}
	
	private static int dijkstra(Node src) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0 ; i < N ; i++) {
			Arrays.fill(dijk[i], 0, N, INF);
		}
		dijk[src.r][src.c] = src.w;
		pq.offer(src);
		while (!pq.isEmpty()) {
			Node min = pq.poll();
			int r = min.r;
			int c = min.c;
			int w = min.w;
			if (dijk[r][c] < w) continue;
			if (r == N-1 && c == N-1) return w;
			for (int d = 0 ; d < 4 ; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(inRange(nr, nc) && dijk[nr][nc] > w + map[nr][nc]) {
					dijk[nr][nc] = w + map[nr][nc];
					pq.offer(new Node(nr, nc, w + map[nr][nc]));
				}
			}
		}
		return dijk[N-1][N-1];
	}
	
	private static void compute(int tc) {
		out.append("#"+tc+" "+dijkstra(new Node(0,0,0))+'\n');
	}
	
	public static void main(String[] args) throws Exception {
		final int TC = Integer.parseInt(br.readLine().trim());
		for (int tc = 1 ; tc <= TC ; tc++) {
			init();
			compute(tc);
		}
		System.out.print(out);
		br.close();
	}

}
