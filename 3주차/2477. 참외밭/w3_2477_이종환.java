import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class Main
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		
		int perMeter = sc.nextInt();
		
		int[] directions = new int[6];
		int[] size = new int[6];
		
		int ewMax = 0; // 1,2
		int ewMaxIdx = -1;
		int snMax = 0; // 3,4
		int snMaxIdx = -1;
		
		for (int i = 0; i <6; i++) {
			directions[i] = sc.nextInt();
			size[i] = sc.nextInt();
			
			if ((directions[i] == 1 || directions[i] == 2) && size[i] > ewMax) {
				ewMax = size[i];
				ewMaxIdx = i;
			} else if ((directions[i] == 3 || directions[i] == 4) && size[i] > snMax){
				snMax = size[i];
				snMaxIdx = i;
			}
		}
		
		//잘려나가 부분의 가로세로 길이
		int snCutted = snMax - Math.min(size[(ewMaxIdx+1)%6],size[(ewMaxIdx-1+6)%6]);
		int ewCutted = ewMax - Math.min(size[(snMaxIdx+1)%6],size[(snMaxIdx-1+6)%6]);;
		
		
		int ans = (ewMax * snMax - ewCutted * snCutted) * perMeter;
		
		System.out.println(ans);
		
		
		
	}
}