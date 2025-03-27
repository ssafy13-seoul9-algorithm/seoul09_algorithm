import java.util.Arrays;
import java.util.Scanner;
public class BJ10826 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();

        int res = fib(N);

        System.out.println(res);

    }

    static int fibMem(int N, int[] dp){
        // dp 배열에 피보나치 수열의 0, 1번째 항목의 값을 넣는다.
        if( N <= 1){
            dp[N] = N;
            return dp[N];
        }

        // dp 배열에 피보나치 배열을 저장함으로써, 재귀함수를 모두 계산하지 않고 이미 연산한 값을 이용하여 피보나치 값을 계산한다.
        if( dp[N] !=- 1){
            return dp[N];
        }

        // dp로 계산이 안 됐다면, dp 배열에 계산한 값을 넣는다.
        dp[N] = fibMem(N-1, dp) + fibMem(N-2, dp);

        return dp[N];
    }

    // dp를 이용해 구한 피보나치 수열을 출력한다.
    static int fib(int N){
        int[] dp = new int[N+1];
        Arrays.fill(dp, -1);

        return fibMem(N, dp);

    }

}
