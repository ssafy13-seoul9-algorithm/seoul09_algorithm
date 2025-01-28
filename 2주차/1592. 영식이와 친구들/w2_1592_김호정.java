import java.util.Scanner;

public class w2_1592_김호정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N  = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int cur = 1; // 공 가진 사람
        int cnt = 0; // 공 던진 횟수

        int[] num = new int[N+1];
        
        sc.close();

        for (num[cur] = 1; num[cur] < M; cnt++) {
            if (num[cur] % 2 != 0) {
                cur = (cur + L - 1) % N + 1;
            } 
            else {
                cur = (cur - L - 1 + N) % N + 1;
            }

            // 공을 받은 사람의 횟수 
            num[cur]++;
        }

        System.out.println(cnt);

    }
}