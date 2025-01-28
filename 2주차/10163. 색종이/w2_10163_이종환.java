
import java.util.Scanner;

class w2_10163_이종환
{
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in); 
		
		int[][] arr = new int[1001][1001];
		
		int cnt = sc.nextInt();
		
		int[] numSize = new int[cnt+1];
		
		for (int i = 1; i <= cnt; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int width = sc.nextInt();
			int height = sc.nextInt();
			
			for (int j = 0; j < height; j++) {
				for (int k = 0; k < width; k++) {
					arr[y+j][x+k] = i;
				}
			}
			
		}
		
		for (int i = 0; i< 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				numSize[arr[i][j]]++;
			}
		}
		
		for (int i = 1; i <= cnt; i++) {
			System.out.println(numSize[i]);
		}
		

		
		
	}
}