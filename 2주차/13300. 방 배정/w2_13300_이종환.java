
import java.util.Scanner;

public class w2_13300_이종환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int totalNum = sc.nextInt();
		int max = sc.nextInt();
		
		int[][] classes = new int[2][7];
		
		for (int i = 0; i < totalNum; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			classes[gender][grade]++;
		}
		
		int ans = 0;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 6; j++) {
				int target = classes[i][j];
				if (target == 0) {
					continue;
				} else {
					ans += target/max;
					if (target % max != 0) {
						ans++;
					}
				}
				
			}
		}
		System.out.println(ans);
		
	}
}