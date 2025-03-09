import java.util.Scanner;

public class w8_15650_이종환 {
	static int n,m;
	static int[] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		combination(0,1);
		sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb.toString());
	}
	
	static void combination(int cnt, int start) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
			return;
		}
		
		
		for (int i = start; i<=  n; i++) {
			arr[cnt] = i;
			combination(cnt+1,i+1);
		}
	}
}
