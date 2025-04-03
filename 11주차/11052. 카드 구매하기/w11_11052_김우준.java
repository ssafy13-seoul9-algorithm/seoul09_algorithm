import java.util.Arrays;
import java.util.Scanner;

public class w11_11052_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int[] P = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N+1];

        // dp[1] = Math.max(dp[0] + P[0], P[0]);
        // dp[2] = Math.max(dp[1] + P[0], P[1]);
        // dp[3] = Math.max(dp[2] + P[0], dp[1] + P[1], P[2]);
        // dp[4] = Math.max(dp[3] + P[0], dp[2] + P[1], dp[1] + P[2], P[3]);

        for(int i = 1; i <= N; i++){
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + P[j - 1]);
            }
        }

        System.out.println(dp[N]);
    }
}
