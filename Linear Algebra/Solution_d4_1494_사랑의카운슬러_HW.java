import java.io.*;
import java.util.*;

public class Solution_d4_1494_사랑의카운슬러_HW {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder out = new StringBuilder();
    
	private static final int MAX_N = 20;
    private static int N;
    private static long[] x;
    private static long[] y;
    
    private static long total_x;
    private static long total_y;
    
    private static long minAns;

    static {
    	x = new long[MAX_N];
    	y = new long[MAX_N];
    }
    
    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        
        total_x = 0;
        total_y = 0;
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
            
            total_x += x[i];
            total_y += y[i];
        }

        minAns = Long.MAX_VALUE;
    }
    
    /**
     * @param cnt            현재까지 도착점으로 선택한 지렁이의 수
     * @param start          다음으로 탐색을 시작할 인덱스
     * @param selected_sum_x 선택된(도착점) 지렁이들의 X 좌표 합
     * @param selected_sum_y 선택된(도착점) 지렁이들의 Y 좌표 합
     */
    private static void comb(int cnt, int start, long selected_sum_x, long selected_sum_y) {
        if (cnt == N / 2) {
            // 선택되지 않은 출발점들의 합은 (total - selected)
            // 벡터의 합 = 선택된 합 - 선택되지 않은 합
            //          = selected - (total - selected)
            //          = 2 * selected - total
            long vx = 2 * selected_sum_x - total_x;
            long vy = 2 * selected_sum_y - total_y;

            long currentAns = vx * vx + vy * vy;
            if (currentAns < minAns) {
                minAns = currentAns;
            }
            return;
        }

        for (int i = start; i <= N - (N / 2 - cnt); i++) {
            comb(cnt + 1, i + 1, selected_sum_x + x[i], selected_sum_y + y[i]);
        }
    }
    
    private static void run(int tc) throws Exception {
    	init();
        comb(1, 1, x[0], y[0]);
        out.append("#").append(tc).append(" ").append(minAns).append("\n");
    	
    }
    
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
        	run(tc);
        }
        System.out.print(out.toString());
    }

}