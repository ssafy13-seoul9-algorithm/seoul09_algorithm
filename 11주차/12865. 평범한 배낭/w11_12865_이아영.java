/* 배낭에 넣을 수 있는 물건들의 가치합의 최댓값 
 * -> 매 상태에서 '가치' '무게' 동시에 고려
 * i번째 물건을 봤을 때, 현재 무게(w)가 weight[i]를 견딜 수 있는지 확인해야 함 
 * */

import java.util.Scanner;

public class w11_12865_이아영 {
  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N개의 물건 
		int K = sc.nextInt(); // 최대 버틸 수 있는 무게 K
		// K 전부 안 찰 수도 있으니까 
		
		// N개 무게 & 가치
		int[] weights = new int[N+1];
		int[] cost = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		} // input 
		
		int[][] dp = new int[N+1][K+1]; 
		
		// dp 테이블 채우기
		for (int i = 1; i <= N; i++) {
			for (int w = 0; w <= K; w++	) {
				// 1. 현재 무게가 i번째 물건의 무게를 견딜 수 있는 경우 
				// 이전까지 선택한 최적의 경우와 해당 물건 더하는 최적의 경우 비교 
				if (w >= weights[i]) {
					// 이번 물건 넣는 경우: 무게 감소 & 가치 증가
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]] + cost[i]);
				}
				// 2. 현재 무게가 i번째 물건 무게 못 견디는 경우: 이전까지 선택한게 최적값.
				else {
					// 이번 물건 넣지 않는 경우: 이전까지 가치가 최적값   
					dp[i][w] = dp[i-1][w];
				} 
			}
		}
		
		System.out.println(dp[N][K]);
		
		sc.close();
	}
}
