import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class w10_15989_이종환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int[] dp = new int[10001];
		
		for (int i = 1; i <=10000; i++) {
			dp[i] = (i < 4)? i: dp[i-3] + i/2 + 1;
		}
		
		for (int i = 0 ; i < tc; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}
}
