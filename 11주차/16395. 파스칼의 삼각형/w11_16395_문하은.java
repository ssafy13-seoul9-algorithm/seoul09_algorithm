import java.util.Scanner;

public class boj_16395 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int [][] map = new int [31][31];

        for (int i = 1; i < 31; i++) {
            map[i][1] = 1;
            map[i][i] = 1;

            for (int j = 2; j < i; j++) {
                map[i][j] = map[i-1][j-1] + map[i-1][j];
            }
        }

        System.out.println(map[N][K]);
    }
}
