import java.util.Scanner;

public class w1_1868_김우준 {
    public static int calc(int size, int i, int j, String[][] arr) {
        int count = 0;
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                if (i + x >= 0 && i + x < size && j + y >= 0 && j + y < size) {
                    if (arr[i + x][j + y].equals("*")) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void check(int size, int arr_i, int arr_j, String[][] arr, boolean[][] flag_arr) {
        ArrayList<int[]> queue = new ArrayList<>();
        queue.add(new int[] { arr_i, arr_j });
        flag_arr[arr_i][arr_j] = false;

        while (!queue.isEmpty()) {
            int[] current = queue.remove(0);
            int x = current[0];
            int y = current[1];
            int count = calc(size, x, y, arr);

            arr[x][y] = Integer.toString(count);
            if (count == 0) {
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i + x >= 0 && i + x < size && j + y >= 0 && j + y < size) {
                            if (flag_arr[i + x][j + y] && arr[i + x][j + y].equals(".")) {
                                flag_arr[i + x][j + y] = false;
                                queue.add(new int[] { x + i, y + j });
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(sc.nextLine());
            String[][] arr = new String[N][N];
            boolean[][] flag_arr = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String[] str = sc.nextLine().split("");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str[j];
                    flag_arr[i][j] = true;
                }
            }

            int click = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (flag_arr[i][j] && arr[i][j].equals(".")) {
                        int count = calc(N, i, j, arr);
                        if (count == 0) {
                            check(N, i, j, arr, flag_arr);
                            click++;
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j].equals(".")) {
                        click++;
                    }
                }
            }

            System.out.println("#" + (test_case + 1) + " " + click);
        }
    }
}
