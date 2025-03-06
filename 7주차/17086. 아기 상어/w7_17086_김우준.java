import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N][M];
        // 상어와의 가장 가까운 거리 확인용 배열 선언
        int[][] distance = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            input = sc.nextLine().split(" ");
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(input[j]);
                if(arr[i][j] == 1){
                    // 만약 현재 위치가 상어일 경우 초기 큐 삽입
                    queue.offer(new int[]{i, j});
                    // 현재 위치의 최소 거리 0
                    distance[i][j] = 0;
                } else {
                    // 미 탐색구간은 -1로 초기화
                    distance[i][j] = -1;
                }
            }
        }

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        int max = 0;
        while(!queue.isEmpty()){
            // 현재 위치 x,y 초기화
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && distance[nx][ny] == -1){
                    // 8방향 탐색하며 미탐색 구간인 경우 현재 위치의 거리 + 1
                    distance[nx][ny] = distance[x][y] + 1;
                    // 최대거리 갱신
                    max = Math.max(max, distance[nx][ny]);
                    // 큐에 신규 좌표 삽입
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        System.out.println(max);
    }
}
