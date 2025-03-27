import java.util.*;

public class BJ17212 {
    // 동전을 지불하는 방법 중, 최소 개수를 지불하는 방법을 구한다.
    // 동전의 종류
    // 1, 2, 5, 7 원

    // dp[N+1] = min(dp[N] + 1, dp[각 금액 - 각 동전 금액] + 1)
    //  1  2  3  4  5     6   7   8   9   10  11  12
    // [1, 1, 2, 2, (1,3) 2   1   2   2   2   3    2  ]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+1];
        System.out.println(minCoin(dp, N));
        // System.out.println(Arrays.toString(dp));

    }


    static int minCoin(int[] dp, int N){
        int[] coins = {1, 2, 5, 7};

        // 동전 1로 지불하는 것과, 동전 종류에 따라 지불하는 방식 중 더 작은 것을 dp[i]에 저장한다.
        for(int i=1; i <= N; i++){
            for(int coin : coins){
                if(i >= coin)
                    dp[i] = Math.min( dp[i-1] + 1, dp[i - coin] + 1);

            }
        }

        return dp[N];

    }



}
