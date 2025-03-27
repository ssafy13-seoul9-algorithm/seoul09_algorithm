import java.util.Scanner;

public class w10_2156_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] score = N > 2 ? new int[N+1] : new int[3];
        int[] sum = N > 2 ? new int[N+1] : new int[3];

        for(int i = 1; i <= N; i++){
            score[i] = sc.nextInt();
        }

        sum[1] = score[1];
        sum[2] = score[1] + score[2];
        for(int i = 3; i <= N; i++){
            sum[i] = Math.max(sum[i-1], Math.max(sum[i-2] + score[i], sum[i-3] + score[i-1] + score[i]));
        }

        System.out.println(sum[N]);
    }
}

// 1 -> 1
// 2 -> 1 + 2
// 3 -> 1 + 3 OR 2 + 3 OR 1 + 2
// i -> i-1 OR i-2 + i OR i-3 + i-1 + i