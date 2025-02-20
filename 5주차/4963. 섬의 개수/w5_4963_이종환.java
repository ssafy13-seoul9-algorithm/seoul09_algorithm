import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class w5_4963_이종환 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//12시부터 시계방향 이동(크게 의미는 없음)
		int[] dy = {-1,-1,0,1,1,1,0,-1};
		int[] dx = {0,1,1,1,0,-1,-1,-1};
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			if (width == 0 && height == 0) break;
			
			//지도와 visited 생성
			int[][] arr = new int[height][width];
			boolean[][] visited = new boolean[height][width];
			
			for (int i = 0; i < height; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < width; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					// 바다는 이미 방문한 것으로 간주
					if (arr[i][j] == 0) visited[i][j] = true; 
				}
			}
			
			int islandCnt = 0;
			
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (visited[i][j]) continue; // 이미 검사했거나, 바다임
					
					islandCnt++;
					Queue<Integer> qY = new LinkedList<Integer>();
					Queue<Integer> qX = new LinkedList<Integer>();
					
					qY.add(i);
					qX.add(j);
					
					while(!qY.isEmpty()) {
						int y = qY.poll();
						int x = qX.poll();
						
						for (int k = 0; k < 8; k++) {
							int targetY = y + dy[k];
							int targetX = x + dx[k];
							
							if (targetY < 0 || targetX <0 || targetY >= height ||
									targetX >= width || visited[targetY][targetX]) {
								continue;
							}
							
							visited[targetY][targetX] = true;
							qY.add(targetY);
							qX.add(targetX);
						}
					}
					
				}
			}
			
			System.out.println(islandCnt);	
		}		
	}
}
