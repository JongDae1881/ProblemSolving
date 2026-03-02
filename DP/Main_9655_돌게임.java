import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		boolean[] dp = new boolean[Math.max(N + 1, 4)];
		// 기저 조건(Base Case) 세팅
		// true: 현재 턴인 사람이 이김, false: 현재 턴인 사람이 짐
		dp[1] = true;  // 1개 남았을 때: 1개 가져가면 바로 승리
        dp[2] = false; // 2개 남았을 때: 1개만 가져갈 수 있고, 남은 1개를 상대가 가져가므로 패배
        dp[3] = true;  // 3개 남았을 때: 3개 가져가면 바로 승리
        
        // 점화식 (Recurrence Relation) 적용
        for (int i = 4 ; i<= N ; i++) {
        	// 논리 부정 연산자(!)를 사용하여 상대방의 패배 상태를 확인
            // i-1개를 남겨주거나 i-3개를 남겨주었을 때 상대방이 지는 경우(!false)가 하나라도 있다면 나의 승리
            dp[i] = (!dp[i - 1] || !dp[i - 3]);
        }
        
        if (dp[N]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
	}

}
