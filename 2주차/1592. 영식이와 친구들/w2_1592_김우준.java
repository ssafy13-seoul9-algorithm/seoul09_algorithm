import java.util.Scanner;

public class w2_1592_김우준 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int L = Integer.parseInt(input[2]);
        
        int[] cnt = new int[N];

        int pos = 0;
        int time = 0;
        outer: while (true) {
            cnt[pos] += 1;
            if (cnt[pos] % 2 == 0) {
                if (pos - L < 0) {
                    pos = N + pos - L;
                } else {
                    pos -= L;
                }
            } else {
                pos += L;
                pos %= N;
            }
            for (int i = 0; i < N; i++) {
                if (cnt[i] == M) {
                    break outer;
                }
            }
            time++;
        }

        System.out.println(time);
    }
}