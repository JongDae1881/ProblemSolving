import java.io.*;
import java.util.*;

public class Main_S1_23350_K물류창고 {

	// 입출력
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	private static StringBuilder out = new StringBuilder();
	private static StringTokenizer st;
	// 문제에서 주어진 정보
	private static int N, M;
	private static Queue<int[]> q;
	// 문제에서 주어진 정보에서 파생되는 정보
	private static ArrayDeque<int[]> loadSpace; // 적재 공간, 스택으로만 사용
	private static int[] numM;

	private static void init() throws IOException {
	
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new ArrayDeque<int[]>();
		loadSpace = new ArrayDeque<>();
		numM = new int[M];
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			q.offer(new int[] {m, w});
			numM[m-1]++;
		}
	}


	private static int compute() {
	
		int cost = 0;
		int currM = M;
		// 적재 공간의 순서를 지키기 위해 임시로 사용되는 스택(문제 설명에서의 나머지 공간)
		ArrayDeque<int[]> stack = new ArrayDeque<int[]>();
		while (!q.isEmpty()) {
			int[] container = q.poll();
			int m = container[0];
			int w = container[1];
			// 현재 우선 순위가 아니면 레일의 처음으로 다시 보내고, 무게만큼 비용 증가
			if (m != currM) {
				cost += w;
				q.offer(container);
				continue;
			}
			// 현재 우선 순위가 맞다면 적재, 이동하는 컨테이너들의 무게 합산만큼 비용 증가
			// else ( if m == currM )
			// 무게 순서가 맞지 않다면 임시 공간으로 이동
			while ( !loadSpace.isEmpty() && loadSpace.peek()[0] == m && loadSpace.peek()[1] < w ) {
				cost += loadSpace.peek()[1];
				stack.push(loadSpace.pop());
			}
			// 올바른 위치에 적재
			cost += w;
			loadSpace.push(container);
			// 임시 공간으로 옮겼던 컨테이너들을 다시 적재 공간으로 이동
			while (!stack.isEmpty()) {
				cost += stack.peek()[1];
				loadSpace.push(stack.pop());
			}
			// 컨테이너 적재 성공, 현재 우선 순위의 잔여량 1 감소
			numM[currM-1]--;
			// 현재 우선 순위의 컨테이너를 전부 처리했다면 다음 우선 순위로 넘어간다.
			if (numM[currM-1] == 0) currM--;
		}
		return cost;
	}


	public static void main(String[] args) throws Exception {
		init();
		out.append(compute());
		System.out.println(out);
	}
}