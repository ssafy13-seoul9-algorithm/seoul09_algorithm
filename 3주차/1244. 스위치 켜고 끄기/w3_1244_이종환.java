import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;




public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		int[] arr= new int[size];
		
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] == 0) arr[i] =-1; // 계산 편의를 위해
		}
		
		int order = sc.nextInt();
		
		for (int i = 0; i < order; i++) {
			int gender = sc.nextInt();
			int switchNumber = sc.nextInt();
			
			if (gender == 1) {
				for (int j = switchNumber -1; j < size; j+= switchNumber ) {
					arr[j] *= -1;
				}
			} else {
				arr[switchNumber-1] *= -1;
				int distance =0;
				while(true) {
					distance++;
					if ( switchNumber - distance - 1>=0 && switchNumber +distance - 1< size &&
							arr[switchNumber - distance - 1] == arr[switchNumber + distance - 1]) {
						arr[switchNumber - distance - 1] *= -1;
						arr[switchNumber + distance - 1] *= -1;
					} else {
						break;
					}
					
				}
			}
		}
		
		for (int i = 0; i <size; i++) {
			if (arr[i] == -1) arr[i] = 0;
		}
		
		for (int i = 0; i < size; i++) {
			if (i != 0 &&  i % 20 == 0) {
				System.out.println();
			}
			System.out.print(arr[i] +" ");
		}
	}
}