
import java.util.Scanner;

public class w2_1592_이종환 {
	public static void main(String args[])
	{

		Scanner sc = new Scanner(System.in);
		
		int people = sc.nextInt();
		int goal = sc.nextInt();
		int distance = sc.nextInt();
		
		int[] arr = new int[people];
		int target = 0;
		int cnt = 0;
		
		while(true) {
			
			arr[target]++;
			if (arr[target] == goal) break;
			cnt++;
			if (arr[target]%2 == 0) {
				target = (target + people - distance)% people;
			} else {
				target = (target + distance)% people;
			}
		
		}
		
		System.out.println(cnt);
	}
}
