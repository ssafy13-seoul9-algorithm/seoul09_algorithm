import java.util.Arrays;
import java.util.Scanner;

public class w10_17212_이종환 {
	public static void main(String[] args) {
		int[] arr = new int[1000001];
		int[] coin = {1,2,5,7};
		Arrays.fill(arr, Integer.MAX_VALUE/2);
		
		arr[1] = arr[2] = arr[5] = arr[7] = 1;
		
		for (int i = 1; i <= 99993;i++) {
			for (int j = 0; j < 4; j++) {
				if (i + coin[j] > 100000) continue;
				arr[i+coin[j]] = Math.min(arr[i+coin[j]], arr[i]+1);
			}
		}
		arr[0] = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println(arr[sc.nextInt()]);
	}
}
