import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int time = Integer.parseInt(sc.nextLine());
		for(int t = 0; t < time; t++) {
			String[] arr = sc.nextLine().split("");
			
			int point = 1;
			int sum = 0;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i].equals("O")) {
					sum += point;
					point++;
				}
				else {
					point = 1;
				}
			}
			System.out.println(sum);
		}
	}
}