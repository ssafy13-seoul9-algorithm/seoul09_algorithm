import java.util.Scanner;


class w2_2810_이종환
{
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int ans = 0;

	
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		
		int seatNum = sc.nextInt();
		sc.nextLine();
		
		String input = sc.nextLine(); 
		
		int coupleCnt = 0;
		
		for (int i = 0; i < seatNum; i++ ) {
			if (input.charAt(i) == 'L') {
				coupleCnt++;
			}
		}
		
		System.out.print(Math.min(seatNum, seatNum + 1 - coupleCnt/2));
	}
}