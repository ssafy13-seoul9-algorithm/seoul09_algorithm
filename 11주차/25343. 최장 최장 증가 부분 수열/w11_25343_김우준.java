import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class w11_25343_김우준 {
    static int[][] board;
    static int[][] memo;
    static int N;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];
        memo = new int[N+1][N+1];
        max = 0;
        for(int i = 1; i <= N; i++){
            Arrays.fill(memo[i], 1);
        }

        for(int i = 1; i <= N; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 1; j <= N; j++){
                board[i][j] = input[j-1];
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                for(int k = 1; k <= i; k++){
                    for(int l = 1; l <= j; l++){
                        if(board[k][l] >= board[i][j]) continue;
                        // 오 마이 카미사마 그냥 N^4 돌려버리기
                        // 그냥 N^2 으로 푸는 LIS
                        // 그냥 0..ij까지 다 비교해서 크면 +1
                        // n log n 으로 했다가 2^n * n log n 으로 뚜드려 맞아버리기
                        memo[i][j] = Math.max(memo[i][j], memo[k][l] + 1);
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                max = Math.max(max, memo[i][j]);
            }
        }

        System.out.println(max);
    }
}