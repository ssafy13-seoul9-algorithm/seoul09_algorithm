import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class w2_2999_이종환 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int ans = 0;

	
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		
		String rawInput = sc.nextLine();
		
		String[] input = rawInput.split("");
		int len = input.length;
		int r = 1; 
		
		for (int i = 1; i <= Math.sqrt(len); i++) {
			if (len % i == 0) {
				r = i;
			}
		}
		
		int c = len/r;
		
		String[][] arr = new String[c][r];
		
		int idx = 0;
		
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				arr[i][j] = input[idx++];
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[j][i]);
			}
		}
		
		
		
	}
}
