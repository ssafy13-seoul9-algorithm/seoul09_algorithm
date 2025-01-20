import java.util.Scanner;

public class w1_1486_김우준 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 0; test_case < T; test_case++) {
            String[] str = sc.nextLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);
            
            //입력 받은 N명 만큼 배열 선언
            str = sc.nextLine().split(" ");
            int[] arr = new int[N];

            // 배열에 N명의 키 할당
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // 최솟값을 찾아야 하므로 Integer.MAX_VALUE로 최대값 할당
            int result = Integer.MAX_VALUE;

            // 모든 경우의 수를 탐색 해야 하므로 2^N 만큼 반복
            for (int i = 1; i < (1 << N); i++) {
                int sum = 0;
                // 2^N 일 때 j번째 요소가 포함 될 경우 합산
                // 1 1 1 1 1 << 2^N 일 경우 AND 연산시,
                // 0 0 0 0 1 -> 1 << 0
                // 0 0 0 1 0 -> 1 << 1
                // 0 0 1 0 0 -> 1 << 2
                // 0 1 0 0 0 -> 1 << 3
                // 1 0 0 0 0 -> 1 << 4
                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) != 0) {
                        sum += arr[j];
                    }
                }

                // 합이 B보다 크고, result 보다 작을 경우 result에 할당 
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