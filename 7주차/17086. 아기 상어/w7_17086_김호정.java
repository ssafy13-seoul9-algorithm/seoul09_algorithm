
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] matrix = new int[N][M];
        int[][] distance = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] == 1) {
                    // 상어 있는 칸 좌표 큐에 넣기
                    queue.add(new int[]{i, j});
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = -1;
                }
            }
        }

        int maxDist = 0;  // 안전 거리의 최댓값 저장
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();  // 큐에서 원소 꺼내기
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 8; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 방문 안 한 칸
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && distance[nx][ny] == -1) {
                    distance[nx][ny] = distance[x][y] + 1;
                    maxDist = Math.max(maxDist, distance[nx][ny]);    // 최대값 갱신
                    queue.add(new int[]{nx, ny});
                }
            }

        }
        System.out.println(maxDist);

    }
}
