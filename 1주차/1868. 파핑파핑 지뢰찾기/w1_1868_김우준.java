import java.util.ArrayList;
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
            // N * N 크기의 배열 생성
            // N * N 크기의 flag 배열 생성
            String[][] arr = new String[N][N];
            boolean[][] flag_arr = new boolean[N][N];

            // 배열에 문자할당 flag 배열 초기화 
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
                    // 만약 [i][j] 요소에 한번도 접근한 적이 없고, [i][j] 요소가 "." 이라면 calc 메서드 수행
                    // calc메서드는 주변 8칸의 지뢰 갯수를 탐색 후 지뢰 개수를 반환
                    if (flag_arr[i][j] && arr[i][j].equals(".")) {
                        int count = calc(N, i, j, arr);
                        // 만약 탐색된 지뢰가 없다면 check 메서드를 수행하여 flag[i][j]를 방문으로 체크
                        // queue에 [i, j]추가 및 주변 8칸에 지뢰가 탐색될 때 까지 queue에 [i+x][j+y]를 추가하여 재귀적으로 탐색
                        if (count == 0) {
                            check(N, i, j, arr, flag_arr);
                            // 모든 인접한 안전지대를 확인 후 클릭 수 1 증가
                            click++;
                        }
                    }
                }
            }

            // 모든 인접한 안전지대를 제외한 나머지 "." 확인을 위한 클릭 횟수 추가
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
