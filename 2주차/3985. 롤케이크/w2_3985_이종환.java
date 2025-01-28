
import java.util.Scanner;


class w2_3985_이종환
{

	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();
		
		int[] arr = new int[len+1];
		
		int people = sc.nextInt();
		
		int expectedMax = 0;
		int expectedIdx = 0;
		int realMax = 0;
		int realIdx = 0;
		
		for (int i = 1; i <= people; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int currentCnt = 0;
			
			if (expectedMax < end - start +1) {
				expectedMax = end - start + 1;
				expectedIdx = i;
			}
			
			for (int j = start; j <= end; j++){
				if (arr[j] == 0 ) {
					arr[j] = i;
					currentCnt++;
				}
			}
			if (currentCnt > realMax) {
				realMax = currentCnt;
				realIdx = i;
			}
			

		}
		System.out.println(expectedIdx);
		System.out.println(realIdx);
			
			
		
		
		
	}
}