import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class w8_6603_이종환 {
	
	static int[] arr;
	static int[] comb = new int[6];
	static int size; 
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			size = Integer.parseInt(st.nextToken());
			
			if (size == 0) break;
			
			arr = new int[size];
			for (int i = 0; i < size; i++) arr[i] = Integer.parseInt(st.nextToken());
			
			combination(0,0);
			System.out.println(sb.toString());
		}
	}
	
	static void combination(int cnt, int start) {
		if (cnt == 10) {
			for (int i = 0; i < 10; i++) {
				sb.append(comb[i]).append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
			return;
		}

		for (int i = start; i< size; i++) {
			comb[cnt] = arr[i];
			combination(cnt+1,i+1);
		}
	}
}
