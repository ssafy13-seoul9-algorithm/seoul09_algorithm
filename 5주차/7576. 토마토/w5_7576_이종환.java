import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class w5_7576_이종환
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		int[] dy = {1,0,-1,0};
		int[] dx = {0,1,0,-1};
		
		//지도와 visited 생성
		int[][] arr = new int[height][width];
		boolean[][] visited = new boolean[height][width];

		
		Queue<Integer> qY = new LinkedList<Integer>();
		Queue<Integer> qX = new LinkedList<Integer>();
		
		int totalTomatoCnt = height * width;
		int tomatoCnt = 0; // 익거나 못가는 곳 개수
		
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0 ) {
					// 갈수 없는 곳이거나, 익은 토마토일때
					if (arr[i][j] == 1) {
						qY.add(i);
						qX.add(j);
					}
					tomatoCnt++;
					visited[i][j] = true;
				} 
			}
		}
		
		
		int time = 0;
		
		while(!qY.isEmpty() && tomatoCnt != totalTomatoCnt) {
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
					tomatoCnt++;
					visited[targetY][targetX] = true;
					
					qY.add(targetY);
					qX.add(targetX);
				}
			}
			time++;
		}
		
		
		if (tomatoCnt != totalTomatoCnt) {
			System.out.println(-1);
		} else {
			System.out.println(time);
		}
	}
}
