import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class w10_2156_이종환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		
		int[] wine = new int[len+1];
		int[][] dp = new int[len+1][3]; //몇개 연속인지
		for (int i = 1; i <= len ; i++) wine[i] = Integer.parseInt(br.readLine());
		
		dp[1][1] = wine[1];
		
		for(int i = 2; i <= len; i++) {
			dp[i][0]= Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][0]));
			dp[i][1]= dp[i-1][0] + wine[i];
			dp[i][2]= dp[i-1][1] + wine[i];
			
		}
		System.out.println(Math.max(dp[len][0],Math.max(dp[len][1], dp[len][2])));
	}

}
