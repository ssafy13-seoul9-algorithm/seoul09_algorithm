import java.util.Scanner;

public class w1_4193_김우준 {

    public static void check(int[][] arr, int size, int[] arr1, int[] arr2) {

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (arr1[0] + i >= 0 && arr1[0] + i < size && arr1[1] + j >= 0 && arr1[1] + j < size) {
                    if (i == 0 || j == 0) {
                        int cases = decide(arr[arr1[0] + i][arr1[1] + j]);
                        if(arr2[0] == arr1[0] + i && arr2[1] == arr1[1] + j) {
                            // time++;
                            // break;
                        }

                        if (cases == 1) {
                            // 종료
                        } else if (cases == 2) {
                            // time += (time % 3)
                            // check()
                        } else {
                            // time++;
                            // check()
                        }

                    }
                }
            }
        }
    }

    public static int decide(int arr) {
        int cases = switch (arr) {
            case 2 -> {
                yield 2;
            }
            case 1 -> {
                yield 1;
            }
            default -> {
                yield 0;
            }
        };

        return cases;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int test_case = 0; test_case < t; test_case++) {
            int N = Integer.parseInt(sc.nextLine());
            int[][] arr = new int[N][N];
            boolean[][] flagArr = new boolean[N][N];

            String[] str = sc.nextLine().split(" ");
            int[] startPoint = { Integer.parseInt(str[0]), Integer.parseInt(str[1]) };

            str = sc.nextLine().split(" ");
            int[] endPoint = { Integer.parseInt(str[0]), Integer.parseInt(str[1]) };

            int time = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                }
            }

            check(arr, N, startPoint, endPoint);
        }

    }
}