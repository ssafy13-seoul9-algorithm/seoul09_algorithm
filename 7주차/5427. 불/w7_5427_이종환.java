
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;


public class w7_5427_이종환
{
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] visited;
	
	static int width;
	static int height;
	static boolean isFire;
	static Queue<Point> fireQueue = new ArrayDeque<>();
	static Queue<Point> humanQueue = new ArrayDeque<>();
	
	public static void main(String args[]) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < tc; test_case++) {
			String[] rawInput = br.readLine().split(" ");
			width = Integer.parseInt(rawInput[0]);
			height = Integer.parseInt(rawInput[1]);
			
			// 벽은 사람 불 모두 못지나가는 3;
			// 불이 퍼진 곳은 2;
			// 사람이 지나간 곳은 1; 
			// 안 지나간 곳은 0;
			visited  = new int[height][width];
			
			for (int i = 0; i < height; i++) {
				String[] input = br.readLine().split("");
				
				for (int j = 0; j < width; j++) {
					if (input[j].equals("#")){
						visited[i][j] = 3;
						
					} else if (input[j].equals("*")) {
						visited[i][j] = 2;
						fireQueue.add(new Point(j,i));
						
					} else if (input[j].equals("@")) {
						visited[i][j] = 1;
						humanQueue.add(new Point(j,i));
					}
				}
			}
			
			
			int sec = 0;
			boolean canEscape = false;
			
			outerLoop:
			while (humanQueue.size() != 0) {
				sec++;
				int fireCnt = fireQueue.size();
				int humanCnt = humanQueue.size();
				
				isFire = true;
				for (int i = 0; i < fireCnt; i++ ) {
					Point coordi = fireQueue.poll();
					int y = coordi.y;
					int x = coordi.x;
					bfs(y, x, visited);
				}
				
				isFire = false;
				for (int i =0; i < humanCnt; i++) {
					Point coordi = humanQueue.poll();
					int y = coordi.y;
					int x = coordi.x;
					if (y == 0 || x == 0 || y == height-1 || x == width-1) {
						canEscape = true;
						break outerLoop;
					}
					bfs(y, x, visited);
				}
			}
			
			
			bw.append(((canEscape)?sec+"\n":"IMPOSSIBLE\n"));
			
			fireQueue.clear();
			humanQueue.clear();
			
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void bfs(int y, int x , int[][] visited ) {
		
		for (int i = 0; i < 4; i ++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			
			if (ty < 0 || tx <0 || tx >= width || ty >= height 
					|| visited[ty][tx] >= 2 ) {
				continue;
			} 
			
			if (isFire) {
				visited[ty][tx] = 2;
				fireQueue.add(new Point(tx,ty) );
			} else if (visited[ty][tx] == 0) {
				visited[ty][tx] = 1;
				humanQueue.add(new Point(tx,ty));
			}
			
			
			
		}
	}
}