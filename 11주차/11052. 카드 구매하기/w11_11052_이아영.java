import java.util.Scanner;

public class w11_11052_이아영 {
  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1개, 2개, ..., N개 
		int N = sc.nextInt(); // 카드 N개
		int[] cards = new int[N+1]; 
		int[] dp = new int[N+1];

		// 카드 N개
		for (int i = 1; i <= N; i++) cards[i] = sc.nextInt();
		
		dp[0] = 0; 
		dp[1] = cards[1]; // 1 하나
		
		for (int i = 2; i <= N; i++	) {
			int max = cards[i]; // 초기화
			
      // dp(3) + card(1) or dp(2) + card(2) or dp(1) + card(3) or card(4)
      // 직접 계산해서 점화식 찾아봄봄
			for (int j = 1; j < i; j++) {
				int tmp = dp[i-j] + cards[j];
				if (max < tmp) max = tmp;
			}
			dp[i] = max;
		}
		
		System.out.println(dp[N]);
		sc.close();
	}
}
