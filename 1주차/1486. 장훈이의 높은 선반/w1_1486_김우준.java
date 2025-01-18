import java.util.Scanner;

public class w1_1486_김우준 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 0; test_case < T; test_case++) {
            String[] str = sc.nextLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);

            str = sc.nextLine().split(" ");
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            int result = Integer.MAX_VALUE;

            for (int i = 1; i < (1 << N); i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    if (i & (1 << j)) {
                        sum += arr[j];
                    }
                }

                if (sum > B) {
                    if (sum < result) {
                        result = sum;
                    }
                }
            }

            System.out.println("#" + (test_case + 1) + " " + (B - result));
        }
    }
}