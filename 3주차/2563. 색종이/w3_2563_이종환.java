import java.util.Scanner;


class Main
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		boolean[][] visited = new boolean[100][100];
		
		for (int i = 0; i < cnt; i++) {
			int startX = sc.nextInt()-1;
			int startY = sc.nextInt()-1;
			
			for (int j = startY; j < startY +10; j++) {
				for (int k = startX; k < startX + 10; k++) {
					visited[j][k] = true;
				}
			}
		}
		
		int ans = 0;
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (visited[i][j])ans++;
			}
		}
		
		System.out.println(ans);
		
	}
}