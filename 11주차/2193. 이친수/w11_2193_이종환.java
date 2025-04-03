import java.util.Scanner;

public class w11_2193_이종환 {
	static long[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int goal = sc.nextInt();
		dp = new long [goal][2];
		
		dp[0][1] = 1;
		for (int i = 1; i < goal; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		
		System.out.println(dp[goal-1][0] + dp[goal-1][1]);
		
		
	}
}
