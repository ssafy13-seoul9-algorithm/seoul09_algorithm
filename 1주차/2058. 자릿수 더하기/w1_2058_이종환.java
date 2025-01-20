import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class w1_2058_이종환 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		
		while(true) {
			sum += a%10;
			if (a < 10) {
				break;
			}
			a /= 10;
			
		}
		
		System.out.println(sum);
	}
}

