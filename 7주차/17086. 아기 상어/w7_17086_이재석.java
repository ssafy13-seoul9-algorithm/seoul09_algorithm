import java.util.*;

public class BJ17086 {
	static int[] dx = {-1, 1, 0, 0, -1, -1,  1, 1 };
	static int[] dy = {0, 0, -1, 1, -1,  1, -1, 1 };

	static int N,M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int maxSafeDistance = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==0){
					int dist = bfs(arr, i, j);
					maxSafeDistance = Math.max(maxSafeDistance, dist);
				}

			}
		}

		System.out.println(maxSafeDistance);
		// System.out.println(Arrays.deepToString(arr));

	}

	static int bfs(int[][] arr, int x, int y){
		boolean[][] visited = new boolean[N][M];
		// int[][] deltaArr = new int[8][2];

		int[] dx = {-1, 1, 0, 0 , -1, -1,  1, 1 };
		int[] dy = { 0, 0, -1, 1,  1, -1,  1, -1 };


		Queue<int[]> q = new LinkedList<>();
		// x, y 좌표 및 거리를 queue에 저장한다.
		int[] a = {x,y,0};
		q.add(a);
		visited[x][y] = true;

		while(!q.isEmpty()){
			int[] curr = q.poll();
			int currX = curr[0];
			int currY = curr[1];
			int dist = curr[2];

			// 현재 위치에 아기 상어가 있다면, 거리 반환한다.
			if(arr[currX][currY]==1){
				return dist;
			}

			// 탐색할 수 있고 방문하지 않은 곳을 queue에 추가한다.
			for(int i=0; i<8; i++){
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]){
					visited[nx][ny] = true;
					q.add(new int[]{nx, ny, dist+1});
				}
			}

		}

		return -1;


	}

}
