import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class w8_19949_이종환 {
	
	static int[] answer = new int[10];
	static int[] choices = new int[10];
	static int result = 0;
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 10; i++) answer[i] = Integer.parseInt(st.nextToken());
		
		combination(0,0,0);
		System.out.println(result);
	}
	
	static void combination(int cnt, int sequenceNum, int sequenceCnt ) {
		if (cnt == 10) {
			int correct =0;
			
			for (int i = 0; i < 10; i++) {
				correct += (choices[i] == answer[i])?1:0;
			}
	
			if(correct >= 5) result++;
			return;
		}
		
		for (int i = 1; i<= 5; i++) {
			if (i == sequenceNum ) {
				if (sequenceCnt == 2) continue;
				choices[cnt] = i;
				combination(cnt+1,i,sequenceCnt+1);
				continue;
			}
			
			choices[cnt] = i;
			combination(cnt+1,i,1);
		}



	}
}
