import java.util.Scanner;
import java.util.stream.Stream;


class w2_8320_이종환
{

	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		int cnt = 0;
		
		int divisor = 1;
		
		while (divisor <= Math.sqrt(input)) {
			cnt += input/divisor - divisor + 1;
			
			divisor++;
		}
		
		System.out.println(cnt);
			
			
		
		
		
	}
}