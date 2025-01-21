import java.util.*;

public class w1_2058_이아영 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int sum = 0;
		for (int i = 0; i < N.length(); i++) {
			int val = 0;
			val = N.charAt(i) - '0';
			sum += val;
		}
		sc.close();
		System.out.println(sum);
	}
}
