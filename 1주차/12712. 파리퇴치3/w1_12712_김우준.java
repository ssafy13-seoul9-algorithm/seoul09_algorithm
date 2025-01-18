import java.util.Scanner;

public class w1_12712_김우준 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 0; test_case < T; test_case++) {
            String[] str = sc.nextLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                str = sc.nextLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }

            int result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int plus = arr[i][j];
                    int cross = arr[i][j];
                    int max = 0;

                    for (int m = 1; m < M; m++) {
                        if (i + m < N)
                            plus += arr[i + m][j];
                        if (i - m >= 0)
                            plus += arr[i - m][j];
                        if (j + m < N)
                            plus += arr[i][j + m];
                        if (j - m >= 0)
                            plus += arr[i][j - m];

                        if (i + m < N && j + m < N)
                            cross += arr[i + m][j + m];
                        if (i + m < N && j - m >= 0)
                            cross += arr[i + m][j - m];
                        if (i - m >= 0 && j + m < N)
                            cross += arr[i - m][j + m];
                        if (i - m >= 0 && j - m >= 0)
                            cross += arr[i - m][j - m];
                    }
                    max = (plus > cross) ? plus : cross;
                    result = (max > result) ? max : result;
                }
            }

            System.out.println("#" + (test_case + 1) + " " + result);
        }
    }
}