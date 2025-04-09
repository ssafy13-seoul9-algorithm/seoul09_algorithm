import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class w12_1049_이종환 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int brokenCnt = Integer.parseInt(st.nextToken());
		int brandCnt = Integer.parseInt(st.nextToken());
		
		int packageMin = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < brandCnt; i++) {
			st = new StringTokenizer(br.readLine());
			packageMin = Math.min(packageMin, Integer.parseInt(st.nextToken()));
			min = Math.min(min, Integer.parseInt(st.nextToken()));
		}
		
		if (packageMin < min*6) {
			int packageCnt = brokenCnt/6;
			int left = brokenCnt%6;
			System.out.println( Math.min(packageCnt*packageMin + left*min ,(packageCnt+1)*packageMin ));
		} else {
			System.out.println(brokenCnt*min);
		}
		
		
	}
}
