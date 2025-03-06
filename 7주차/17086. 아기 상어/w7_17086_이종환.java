import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class w7_17086_이종환 {
	
	static int[] dx = {1,1,1,0,0,-1,-1,-1};
	static int[] dy = {0,1,-1,1,-1,0,1,-1};	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken()); 
		
		int[][] arr =new int[height][width];
		
		Queue<Pair> sharks = new LinkedList<>();
		
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				arr[i][j] = -1;
				
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					sharks.add(new Pair(i,j,0));
				}
			}
		}
		
		
		while (!sharks.isEmpty()) {
			boolean[][] visited =new boolean[height][width];
			Queue<Pair> bfsQ = new LinkedList<>();
			Pair start = sharks.poll();
			
			bfsQ.add(start);
			arr[start.y][start.x] = start.distance;
			
			visited[start.y][start.x] = true;
			
			// 상어마다 bfs 실행
			while (!bfsQ.isEmpty()) {
				Pair temp = bfsQ.poll();
				
				int y = temp.y;
				int x = temp.x;
				int distance = temp.distance;
				
				for (int i = 0; i < 8; i++) {
					int targetY = y + dy[i];
					int targetX = x + dx[i];
					
					if ( targetY < 0 || targetX < 0 || targetY >= height || targetX >= width 
							|| visited[targetY][targetX]) {
						continue;
					} 
					
					visited[targetY][targetX] = true;
					
					if (arr[targetY][targetX] == -1) {
						// 아무도 방문하지 않은 곳
						arr[targetY][targetX] = distance +1;
					} else if (arr[targetY][targetX] < distance+1) {
						// 방문했는데 이미 더 가까운거리에 상어 존재
						 continue;
					} else {
						arr[targetY][targetX] = distance+1;
					}
					
					
					bfsQ.add(new Pair(targetY,targetX,distance+1));
				}
			}
			
			
		}
		
		int max = 0;
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				max = Math.max(max, arr[i][j]);
			}
		}
		
		System.out.println(max);
		
		
	}
}

class Pair{
	int y;
	int x;
	int distance = 0;
	
	public Pair(int y, int x, int distance) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.x = x;
		this.distance = distance;
	}
	
}