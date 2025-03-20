import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalCnt = sc.nextInt();
		int perDelete = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= totalCnt; i++) {
			q.add(i);
		}
		
		while(true) {
			int first = q.poll();
			
			for (int i = 1; i < perDelete; i++) {
				if (q.isEmpty()) break;
				q.poll();
			}
			
			if (q.size() == 0) {
				System.out.println(first);
				break;
			}
			q.add(first);
		}
	}
}
