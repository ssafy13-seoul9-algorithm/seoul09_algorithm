
import java.util.Arrays;
import java.util.Scanner;

public class w4_2776_김호정 {
    public static void main(String[] args) {
        // 테스트 케이스 개수 T
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int a = 0; a < T; a++) {
            int N = sc.nextInt();
            int[] arrN = new int[N];
            for(int i=0;i<N;i++) {
                arrN[i] = sc.nextInt();
            }

            Arrays.sort(arrN);

            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                int target = sc.nextInt();

                // Arrays.binarySearch를 사용하여 탐색
                if (Arrays.binarySearch(arrN, target) >= 0) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }

            }

        }
    }
}