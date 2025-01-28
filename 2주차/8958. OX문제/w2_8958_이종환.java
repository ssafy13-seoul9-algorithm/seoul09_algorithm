import java.util.Scanner;
import java.util.stream.Stream;


class w2_8958_이종환
{

	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < tc; i++) {
			String[] input = sc.nextLine().split("");
			int curPoint = 0;
			int sum = 0;
			
			for (int j = 0; j < input.length; j++) {
				if (input[j].equals("O")) {
					sum += ++curPoint;
				} else {
					curPoint = 0;
				}
			}
			
			System.out.println(sum);
		}
			
		
	}
}
