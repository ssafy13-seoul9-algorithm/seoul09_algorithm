import java.util.Scanner;

public class w1_1961_이종환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
            System.out.println("#" + (i+1));
			int size = sc.nextInt();
			
			int arr[][] = new int[size][size];
			
			for (int j = 0; j< size; j++) {
				for (int k = 0; k < size; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			for (int line = 0; line < size; line++) {
				for (int j = size -1; j >= 0; j--) {
					System.out.print(arr[j][line]);
				}
				System.out.print(" ");
				for (int j = size -1; j >= 0; j--) {
					System.out.print(arr[size-1-line][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < size; j++) {
					System.out.print(arr[j][size-1-line]);
				}
				System.out.println();
			}
			

			
		}
	}
} 