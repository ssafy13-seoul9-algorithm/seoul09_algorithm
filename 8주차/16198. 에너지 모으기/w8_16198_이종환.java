import java.util.Scanner;

public class w8_16198_이종환 {
	
	static int size;
	static boolean[] used;
	static int[] beads;
	static int max = 0;
	static int pre = -1;
	static int next = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		
		beads = new int[size];
		used = new boolean[size];
		
		for (int i = 0; i < size; i++) beads[i] = sc.nextInt();
		
		process(0,0);
		System.out.println(max);
	}
	
	private static void process(int cnt,int sum) {
		if (cnt == size -2) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 1; i < size-1; i++) {
			if (used[i]) continue;
			
			used[i] = true;
			setPreAndNext(i);
			int score = beads[pre]*beads[next];
			process(cnt+1, sum + score);
			used[i] = false;
		}
	}
	
	private static void setPreAndNext(int idx) {
		for (int j = idx-1; j >= 0; j--) {
			if (!used[j]) {
				pre = j;
				break;
			}
		}
		
		for (int j = idx+1; j < size; j++) {
			if (!used[j]) {
				next = j;
				break;
			}
		}
	}
	
}
