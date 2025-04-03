import java.util.Arrays;
import java.util.Scanner;

public class w11_12865_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = input[0];
        int K = input[1];

        int[][] object = new int[N+1][2];
        for(int i = 1; i <= N; i++){
            input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 0: Weight, 1: Value
            object[i][0] = input[0];
            object[i][1] = input[1];
        }

        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= K; j++){
                // S(i) = S(i-1) + object[i] || S(i-1)
                if(j >= object[i][0]) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - object[i][0]] + object[i][1]);
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
