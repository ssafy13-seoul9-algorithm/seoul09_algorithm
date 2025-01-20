import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class w1_1959_이종환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int aSize = sc.nextInt();
			int bSize = sc.nextInt();
			
			int aArr[] = new int[aSize];
			int bArr[] = new int[bSize];
			
			for (int j = 0; j < aSize; j++) {
				aArr[j] = sc.nextInt();
			}
			for (int j = 0; j < bSize; j++) {
				bArr[j] = sc.nextInt();
			}
			
			int maxSum = 0;
			
			if ( aSize >= bSize) {
				int diff =  aSize - bSize ;
				
				for (int j = 0; j <= diff; j++) {
					int curSum = 0;
					for (int k = 0; k < bSize; k++) {
						curSum += bArr[k] * aArr[k+j];
					}
					
					maxSum = Math.max(maxSum, curSum);
					
				}
			} else {
				int diff =  bSize - aSize ;
				
				for (int j = 0; j <= diff; j++) {
					int curSum = 0;
					for (int k = 0; k < aSize; k++) {
						curSum += aArr[k] * bArr[k+j];
					}
					
					maxSum = Math.max(maxSum, curSum);
					
				}
			}
			
			System.out.println("#"+(i+1) + " " + maxSum);

			
		}
	}
} 