/* **** 못 풀어서 푼데까지 올렸어여 **** */

import java.util.Scanner;

public class w11_11568_이아영 {
  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 카드 N장
		int[] cards = new int[N];
		
		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextInt(); 
		}
		
		// [0] i번째까지 봤을 때 가장 마지막 수열 
		// [1] i번째까지 봤을 때 가장 긴 개수 
		int[][] dp = new int[N][2]; 
		// 단순하게 가장 작은 수 저장해놓고 카운트 세면 안됨? 
		dp[0][0] = cards[0];
		dp[0][1] = 1; // cnt 대체  
		
		for (int i = 1; i < N; i++) {
			// 8 9 1 2 10이라면 (LIS)
			// 8: LIS 저장, cnt up  
			// 9: 8보다 크니까 LIS 8 9 저장, cnt up)   
			// 1: 9보다 작으니까 pass (0) (LIS 8 9)
			// 2: 9보다 작으니까 pass (0) 
			// 10: 9보다 크니까 LIS 저장 (3) 
			
			// dp 테이블에 i번째까지 봤을 때 LIS에서 가장 큰 수 저장 
			// 이전 값과 비교 & 현재값이 더 크면 (1번째는 무조건 1)
			// 이전 값을 가지고 있어야겠는디
//			5(1) 4(0) 3(0) 2(0) 1(1) 6(2) 7(3) 8(4)
			// 현재 값 > LIS의 마지막 값이라면
			if (cards[i] > dp[i-1][0]) {
				dp[i][0] = cards[i]; // 더 큰 값 저장 
				dp[i][1] = dp[i-1][1] + 1; // 수++ 
//				System.out.println("뿅");
			}
			// 이전값이 더 크면 전 값 유지  
			if (cards[i] <= dp[i-1][0]) {
				dp[i][0] = dp[i-1][0];
				dp[i][1] = dp[i-1][1];
			}
		}
//		
//		for (int[] i : dp) {
//			for (int j : i) {
//				System.out.print(j + " ");
//			}
//			System.out.println();
//		}
		// 바로 다음 원소가 작다면, 덮어쓰고 다시 작성
		// dp에 담을 값은, i번째까지 확인했을 때 연속된 수열의 개수
		
		System.out.println(dp[N-1][1]);
		
		sc.close();
	}
}
