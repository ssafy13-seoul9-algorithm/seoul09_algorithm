import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class Main
{
    static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int ans = 0;

	
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		int[][] visited = new int[103][103];
		
		for (int i = 0; i < cnt; i++) {
			int startX = sc.nextInt()+1;
			int startY = sc.nextInt()+1;
			
			for (int j = startY; j < startY +10; j++) {
				for (int k = startX; k < startX + 10; k++) {
					visited[j][k] = 1;
				}
			}
		}
		
		for (int i = 0; i <= 101; i++) {
			for (int j = 0; j <= 101; j++) {
				if (visited[i][j] != visited[i][j+1]) {
					ans++;
				}
				if (visited[j][i] != visited[j+1][i]) {
					ans++;
				}

			}
		}
	
		
		System.out.println(ans);
		
	}
}