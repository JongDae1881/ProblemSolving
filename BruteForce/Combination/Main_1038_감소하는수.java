package BruteForce.Combination;

import java.io.*;
import java.util.*;

public class Main_1038_감소하는수 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 입력 변수
	private static int N;
	// 파생 변수
	private static int numCnt = -1;
	
	private static void comb(int r, int lastDigit, String result) {
		if(r==0) {
			if(++numCnt == N) {
				System.out.println(result);
			}
			return;
		}
		for (int i = r - 1 ; i < lastDigit ; i++) {
			comb(r - 1, i, result + i);
		}
	}
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine().trim());
		br.close();
		
		for(int r = 1 ; r <= 10 ; r++) {
			comb(r, 10, "");
			if (numCnt >= N) {
				return;
			}
		}
		System.out.println(-1);
	}

}

/*
 * 처음 든 문제의 상태 공간은 '순서가 고정'된 수들의 나열들이었다.
 * 따라서 위와 같이 조합으로 풀었다.
 * 하지만 그 과정에서 기존에 알던 조합의 순서와 달랐고 그 부분을 로직으로 짜는 데 꽤나 시간을 썼다.
 * 
 * 풀고 난 후 받은 피드백:
 * 상태 공간에서 길이가 같은 것들(즉, 같은 자릿수들의 모임)만 모아서 보면 조합이 맞지만
 * 결국 모든 길이에 대해 완전탐색을 시행하므로 부분집합 문제로 볼 수 있다.
 * 이에 따라 상태 공간의 크기는 2^10 - 1 = 1023임을 알 수 있다.
 * 또한, 대소 관계에 신경 쓰다 보니 오래 걸렸는데,
 * 숫자 전체를 List에 받아 놓고 마지막에 정렬해서 결과를 출력해도 된다.
 * 구현 난이도 및 실수 등을 고려하면 이 방법이 훨씬 빠르다.
 * 상태 공간의 크기가 1023이므로 log를 취하면 10 밖에 안 걸리므로 사실 무시할만한 시간이다.
 * 엔지니어로서 주어진 조건을 충족한다면 구현 난이도와 실수 가능성을 최대한 줄이는 것이 중요해 보인다.
 * 난 아직 수학자로서의 직업병이 남아 있는 것 같다.
 */