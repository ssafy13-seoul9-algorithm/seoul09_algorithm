import java.util.Scanner;

public class w7_26170_이종환 {
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	
	static int[][] arr =new int[5][5];
	static boolean[][] visited =new boolean[5][5];
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 5 ;i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == -1) visited[i][j] = true;
			}
		}
		
		int y = sc.nextInt();
		int x = sc.nextInt();
		visited[y][x] = true;		
		
		dfs(y,x,0,0);
		
		System.out.println((min == Integer.MAX_VALUE)? (-1): min);
	}
	
	static void dfs(int  y, int x, int cnt, int distance) {
		if (cnt == 3) {
			min = Math.min(distance, min);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int tY = y + dy[i];
			int tX = x + dx[i];
			
			if (tY < 0 || tX < 0 || tY >= 5 || tX >=5 
					|| visited[tY][tX]) {
				continue;
			}
			
			
			
			if (arr[tY][tX] == 1 ) {
				visited[tY][tX] = true;
				dfs(tY,tX, cnt+1, distance+1);
				visited[tY][tX] = false;
			} else {
				visited[tY][tX] = true;
				dfs(tY,tX, cnt, distance+1);
				visited[tY][tX] = false;
			}
			
		}
	}
}