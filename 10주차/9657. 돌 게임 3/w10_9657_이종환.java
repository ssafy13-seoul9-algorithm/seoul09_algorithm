import java.util.Scanner;

public class w10_9657_이종환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		System.out.println((target%7 == 2|| target%7==0)?"CY":"SK");
	}
}