import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int goal = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cost = new int[goal+1];
		int[] dp = new int[goal+1];
		for (int i = 1; i <= goal; i++) cost[i] = Integer.parseInt(st.nextToken());
		
		dp[1] = cost[1];
		
		for (int i = 2; i <= goal; i++) {
			dp[i] = cost[i];
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + cost[j]);
			}
		}
		
		System.out.println(dp[goal]);
		
		
	}
}
