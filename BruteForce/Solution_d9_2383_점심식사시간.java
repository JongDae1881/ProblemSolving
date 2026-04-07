package HW0406;

import java.io.*;
import java.util.*;

public class Solution_d9_2383_점심식사시간 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder out = new StringBuilder();
	private static StringTokenizer st;
	
	static int gridSize;
	static int num_P;
	static int ans;
	
	private static final int MAX_P = 10;
	private static final int NUM_S = 2;
	
	static List<int[]> personList;
	static List<int[]> stairsList;
	static List<Integer>[] waitingList;
	static int[] choice;
	static Queue<Integer> waitingQ;
	
	static {
		personList = new ArrayList<>(MAX_P);
		stairsList = new ArrayList<>(NUM_S);
		waitingList = new List[NUM_S];
		waitingList[0] = new ArrayList<>(MAX_P);
		waitingList[1] = new ArrayList<>(MAX_P);
		choice = new int[MAX_P];
		waitingQ = new ArrayDeque<>();
	}
	
	static void dfs_chooseStairs(int cnt) {
		if(cnt == num_P) {
			sortByArrivalTime();
			int spentTime = Math.max(computeEndTime(waitingList[0], stairsList.get(0)[2]),
									 computeEndTime(waitingList[1], stairsList.get(1)[2]));
			ans = Math.min(ans, spentTime);
			return;
		}
		choice[cnt] = 0;
		dfs_chooseStairs(cnt + 1);
		
		choice[cnt] = 1;
		dfs_chooseStairs(cnt + 1);
	}
	
	
	static void sortByArrivalTime() {
		waitingList[0].clear();
		waitingList[1].clear();
		
		for(int i = 0 ; i < num_P ; i++) {
			int[] person = personList.get(i);
			int[] stairs = stairsList.get(choice[i]);
			waitingList[choice[i]].add(Math.abs(person[0] - stairs[0]) + Math.abs(person[1] - stairs[1]));
		}
		
		Collections.sort(waitingList[0]);
		Collections.sort(waitingList[1]);
	}
	
	static int computeEndTime(List<Integer> waitingList, int stairsTime) {
		int endTime = 0;
		
		waitingQ.clear();
		for(int person : waitingList) {
			if(waitingQ.size() < 3) {
				endTime = person + 1 + stairsTime;
				waitingQ.offer(endTime);
			} else {
				int startTime = Math.max(person + 1, waitingQ.poll());
				endTime = startTime + stairsTime;
				waitingQ.offer(endTime);
			}
		}
		
		return endTime;
	}
	
	static void init() throws IOException {
		personList.clear();
		stairsList.clear();
		num_P = 0;
		gridSize = Integer.parseInt(br.readLine().trim());
		for(int i = 0 ; i < gridSize ; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j = 0 ; j < gridSize ; j++) {
				int token = Integer.parseInt(st.nextToken());
				switch(token) {
				case 0:
					break;
				case 1:
					personList.add(new int[] {i, j});
					num_P++;
					break;
				default:
					stairsList.add(new int[] {i, j, token});
				}
			}
		}
		ans = Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine().trim());
		for(int tc = 1 ; tc <= TC ; tc++) {
			init();
			dfs_chooseStairs(0);
			out.append("#").append(tc).append(" ").append(ans).append("\n");			
		}
		System.out.print(out);
		br.close();
	}

}
