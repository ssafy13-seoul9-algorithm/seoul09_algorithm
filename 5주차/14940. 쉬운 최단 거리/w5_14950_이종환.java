import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class w5_14950_이종환
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		int[] dy = {1,0,-1,0};
		int[] dx = {0,1,0,-1};
		
		//지도와 visited 생성
		int[][] arr = new int[height][width];
		int[][] distances = new int[height][width];
		boolean[][] visited = new boolean[height][width];

		
		int startY = -1;
		int startX = -1;
		
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 1 ) {
					// 갈수 없는 곳이거나, 목표지점일때
					if (arr[i][j] == 2) {
						startY = i;
						startX = j;
					}
					visited[i][j] = true;
				} else {
					distances[i][j] = -1;
				}
			}
		}
		

		Queue<Integer> qY = new LinkedList<Integer>();
		Queue<Integer> qX = new LinkedList<Integer>();
		
		qY.add(startY);
		qX.add(startX);
		
		int time = 1;
		
		while(!qY.isEmpty()) {
			int qSize = qY.size();
			
			for (int i = 0; i < qSize; i++) {
				int y = qY.poll();
				int x = qX.poll();
				
				for (int j = 0; j < 4; j++) {
					int targetY = y + dy[j];
					int targetX = x + dx[j];
					
					if ( targetY < 0 || targetX < 0 || targetY >= height 
							|| targetX >= width || visited[targetY][targetX]) {
						continue;
					}
					
					visited[targetY][targetX] = true;
					distances[targetY][targetX] = time;
					
					qY.add(targetY);
					qX.add(targetX);
				}
			}
			time++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				sb.append(distances[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
			
	
	}
}
