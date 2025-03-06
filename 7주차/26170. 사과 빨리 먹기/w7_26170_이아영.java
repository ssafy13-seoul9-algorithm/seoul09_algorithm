import java.util.*;

// 학생이 지나간 칸은 학생이 해당 칸을 떠나는 즉시 장애물이 있는 칸으로 변경된다
// > 일반 visited 사용할 때도 쓸 수 있는 방법!
public class BOJ26170 {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[5][5];
		
		// 사과(1), 장애물(-1), 빈칸 - 위치 (r, c)
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				board[r][c] = sc.nextInt();
			}
		} // input
		
		// 상하좌우 1칸 이동가능 > 4방 이동  
		// 현재위치 (r, c)에서 사과 3개 먹기 위한 '최소이동횟수'
		// 현재위치 input으로 주어짐 !
		
		// 어차피 이동한 곳은 못 가니까, visited 안 만들고 원본 배열 고쳐도 되지?
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		// 최소이동 > bfs로 모든 경우의 수 파악해보기
		// bfs는 큐 사용 > 2차원배열 좌표 pointer 2개
		Queue<int[]> queue = new LinkedList<>();
		
		// 시작 지점부터 방문 처리 & 큐에 넣기
		board[x][y] = -1;
		queue.offer(new int[]{x, y, 0}); // 시작점 
		// 이동 자체가 불가능하면 -1 출력해야 하므로
		boolean hasMove = false;
		int cnt = 0;
		int minCnt = 0;
		
		
		int ate = 0; // 사과 냠 
		while (!queue.isEmpty()) {
			// 큐에서 빠지는 순간 > 방문 순간.
			// 시작점 직접 다루지 말고, 항상 큐에서 꺼낸 값 기준으로 새로 이동 시작 
			// 이동 가능하면 cnt 새로 출력
			int[] point = queue.poll();
			int curX = point[0];
			int curY = point[1]; 
			int len = point[2]; 
			System.out.println(Arrays.toString(point) + " ");
			
			if (cnt > minCnt) minCnt = cnt;
			
			// point 기준으로 4방탐색 
			for (int dir = 0; dir < 4; dir++) {
				int nextX = curX + dx[dir];
				int nextY = curY + dy[dir];
				
				// 이동 가능 인접값 중 못 가는 것 빼고
				if (inBoard(nextX, nextY) && board[nextX][nextY] != -1) {
					// 하나라도 move가 있다면 > 출력 위함
					hasMove = true;
					
					if (board[nextX][nextY] == 1) ate++; // 사과 냠 
					board[nextX][nextY] = -1; //방문처리
					cnt++; 

					queue.offer(new int[] {nextX, nextY, cnt+1}); // 인접 노드 추가
					// 가능 경우 1방탐색으로 출력, 좌표 이동해서 계속하기
					if (ate == 3) break;
				}
			} // for 
		} // while
		System.out.println(hasMove? minCnt : -1);
		sc.close();
	} // main
	
	// 5*5 이동
	static boolean inBoard(int x, int y) {
		return (x >= 0 && x < 5 && y >= 0 && y < 5);
	}
}
