import java.util.Scanner;
import java.io.FileInputStream;

class w1_1868_이종환
{
	static int[] dY = {1, 1, 1,-1,-1,-1,0,0};
	static int[] dX = {1, 0,-1, 1, 0,-1,-1,1};
	
	public static void calc(int y, int x, int size, int[][] mineArr)
	{
		if (mineArr[y][x] == -1) mineArr[y][x] = 0; 
		else return;
		for (int i = 0; i < 8; i++) {
			int targetY = y + dY[i];
			int targetX = x + dX[i];
			
			if (targetY < 0 || targetY >= size || 
					targetX < 0 || targetX >= size) {
				continue;
			}
			
			if (mineArr[targetY][targetX] == -2) {
				mineArr[y][x]++;
			}
		}
		return;
	}
	
	public static void visit(int y, int x, int size, boolean [][] visited, int[][] mineArr)
	{
		visited[y][x] = true;
		for (int i = 0; i < 8; i++) {
			int targetY = y + dY[i];
			int targetX = x + dX[i];
			
			if (targetY < 0 || targetY >= size || 
					targetX < 0 || targetX >= size) {
				continue;
			} else if (!visited[targetY][targetX] && mineArr[targetY][targetX] == 0) {
				visited[targetY][targetX] = true;
				visit (targetY,targetX, size, visited, mineArr);
			} else {
				visited[targetY][targetX] = true;
			}
		}
		return;
	}
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int size = sc.nextInt();
			sc.nextLine();
			
			char[][] arr = new char[size][size];
			boolean[][] visited = new boolean[size][size];
			int[][] mineArr = new int[size][size];
			
			for (int i =0; i < size; i++) {
				String input = sc.nextLine();
				for (int j = 0; j < size; j++) {
					// 비어있는 곳은 -1
					// 지뢰는 -2
					mineArr[i][j] = -1;
					arr[i][j] = input.charAt(j);
					if (arr[i][j] == '*') {
						mineArr[i][j] = -2;
						visited[i][j] = true;
					}
				}
			}
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					calc(i,j,size,mineArr);
				}
			}
			
			int cnt = 0;
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (mineArr[i][j] == 0 && !visited[i][j]) {
						cnt++;
						visit(i,j,size,visited, mineArr);
					}
				}
			}
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (mineArr[i][j] != 0 && !visited[i][j]) {
						visited[i][j] = true;
						cnt++;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + cnt);
			

		}
	}
	

}