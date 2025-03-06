import java.util.*;

public class BOJ17086 {
	// 8방 탐색 가능
	public static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	public static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	// 1인 위치 기준으로 찾아서 다음 1 만날때까지 bfs 진행
	// 1인 꼭짓점 여러 개 > 매 꼭짓점마다 수행 
	// bfs 수행할 때마다 거리값 받아서 가장 큰 값 출력 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 공간 크기 N*M
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] board = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		} // input

		// 이동은 인접 8방향 / 이동할 때마다 +1
		// 최장거리 찾기?? 
		// bfs: 모든 경우 동시탐색 & 가장 먼 경로 찾기 
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		// board 돌며 start부터 이동하며 1인 값 찾기 
		int maxDist = 0;

		// bfs 시작 시점은 1 만났을 때

		// board 내에서 꼭짓점 이동하며 최초 '1' 찾기
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				// 1인 값들 몽땅 큐에 넣고 bfs 돌리기 
				// 2차원 배열 >> 큐에도 x, y point 들어가야 함 
				if (board[x][y] == 1) {
					// 거리 같이 큐에 주기 
					queue.offer(new int[] {x, y, 0});
					visited[x][y] = true;
					// 3개 나오자나
//					System.out.println("값");
//					System.out.println(x + " " + y);
				}
				// 1이 될 수 있는 값이 1개가 아니자나
			} // y이동
		} // x이동
		
		// 2차원배열 
		// bfs > 8방탐색 하며 꼭짓점 이동
		while (!queue.isEmpty()) {
			// 방문한 point 제외 
			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];
			int dist = curr[2];
//				int dist = 0; 
			// dist 전체 변수로 관리하면 경우의 수마다 관리 XX 
			// 큐에서 주면서 경우마다 관리해야 함 
			
			if (dist > maxDist) maxDist = dist;
			
			// 큐 내에서 8방탐색하며 수행 
			for (int dir = 0; dir < 8; dir++) {
				int nextX = x + dx[dir];
				int nextY = y + dy[dir];
				
				// 범위 내의 1인지 검증 & 미방문 따라가기 
				if (inBoard(nextX, nextY, N, M) && !visited[nextX][nextY]) {
					// 이동
                    // 다음좌표 거리 = 현재거리 + 1
//						dist++;
					visited[nextX][nextY] = true;
					// 범위 내라면 시작점 queue에 넣기 
					queue.offer(new int[] {nextX, nextY, dist+1});
					
				}
			}
		}
		
		System.out.println(maxDist);
		sc.close();

	} // main

	public static boolean inBoard(int x, int y, int xN, int yN) {
		return (x >= 0 && x < xN && y >= 0 && y < yN);
	}
}
