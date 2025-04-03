
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[31][31];
		arr[1][1] = 1;
		for (int i = 2; i < 31; i++) {
			for (int j = 1; j < 31; j++) {
				arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
			}
		}
		
		System.out.println(arr[sc.nextInt()][sc.nextInt()]);
	}
}
