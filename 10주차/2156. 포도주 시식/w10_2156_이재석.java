import java.util.*;

public class BJ2156 {
    // X O O
    // O X O

    // 6
    // 0  1    2      3      4        5
    // 6  10   13     9      8        1
    // 6  16   19,23  28,25  33       26
    // 1,      1+3    1+3+4           1+3+4+6
    //    1+2         1+2+4  1+2+4+5
    //         2+3           2+3+5    2+3+5+6

    static int N;
    static int[] arr;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        for(int i=0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        // System.out.println(Arrays.toString(arr));
        int[] dp = new int[N];
        Arrays.fill(dp, -1);

        System.out.println(findMax(dp));
        // System.out.println(Arrays.toString(dp));

    }

    static int findMax(int[] dp){
        if(N==1) return arr[0];
        if(N==2) return arr[0] + arr[1];

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(Math.max( arr[2] + arr[1], arr[2] + arr[0]), dp[1]);

        if(N==3) return dp[2];

        for(int i = 3; i < N; i++){

            // 1. i 번째 포도주를 마시지 않는 경우
            // 2. i-1번째 포도주는 마시지 않는 경우
            // 3. i-2 번째 포도주를 마시지 않는 경우

            // 자신과 한 칸 떨어져 있는 곳 과의 합, 혹은 자신과 2칸 떨어져 있는 곳과의 합 중에서 큰 것을 dp[i]에 저장하면 된다.
            dp[i] = Math.max( Math.max( dp[i-1], arr[i]+ dp[i-2]), dp[i-3]+arr[i-1]+arr[i]);

        }

        return dp[N-1];
    }

}
