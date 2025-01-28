
import java.util.Scanner;


class w2_2851_이종환
{
	
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		
		int[] mushrooms = new int[10];
		
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			mushrooms[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 10; i++) {
			sum += mushrooms[i];
			
			if (sum >= 100) {
				if (sum - 100 > 100 - sum + mushrooms[i]) {
					sum -= mushrooms[i];
				}
				
				break;
			}
		}
		
		System.out.println(sum);
	}
}