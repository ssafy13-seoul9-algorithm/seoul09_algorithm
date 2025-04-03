/* 값으로 보지 말고 자릿수로 보기 
 * 조건1 0으로 시작하지 않아야 함
 * 조건2 1이 2번 연속으로 나타나지 않아야 함
 * 부분 문자열에 11이 없다 1
 * 2차원배열로 끝이 0일때, 끝이 1일때 2가지 저장 
 * */

import java.math.BigInteger;
import java.util.Scanner;

public class w11_2193_이아영 {
 public static void main(String[] args) {
		// dp 테이블에 저장할 것: 경우의 수?
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 지피티 힌트 = 2차원배열로 마지막 수 0일때 + 1일때 저장 
		BigInteger[][] dp = new BigInteger[N+1][2];
		// 이전 자리까지 보고 저장하기? 

		// 1자리에서는 1, 2자리에서는 10
		dp[1][0] = BigInteger.ZERO; // X
		dp[1][1] = BigInteger.ONE; // 1
		
		if (N >= 2) {
			dp[2][0] = BigInteger.ONE; // 10
			dp[2][1] = BigInteger.ZERO; // X
		}
		
		// 3번째 자리부터는 ...
		for (int i = 3; i <= N; i++) {
			// 현재자리수 0: 이전자리 0도 되고 1도 되고 
			dp[i][0] = dp[i-1][0].add(dp[i-1][1]);
			
			// 현재자리수 1: 이전자리 무조건 0
			dp[i][1] = dp[i-1][0]; 
		}

		
		// 결과는 0일때 경우 + 1일때 경우
		BigInteger res = dp[N][0].add(dp[N][1]);
		System.out.println(res);
	}
}
