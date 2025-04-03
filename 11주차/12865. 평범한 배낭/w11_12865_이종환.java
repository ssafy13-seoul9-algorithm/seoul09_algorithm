import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class w11_12865_이종환 {
	public static void main(String[] args) throws IOException {
		//대표적인 배낭 문제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int inputCnt = Integer.parseInt(st.nextToken());
		int maxWeight = Integer.parseInt(st.nextToken());
		
		//물건의 무게와 가치 저장
		int[][] arr = new int[inputCnt][2];
		// dp[i] - i무게에서의 최대 가치;
		int[] dp = new int[maxWeight+1];
		
		for (int i = 0; i < inputCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			arr[i][0] = weight;
			arr[i][1] = value;
		}
		
		for (int i = 0; i < inputCnt; i++) {
			int weight = arr[i][0];
			int value = arr[i][1];
			for (int j = maxWeight; j >= 0; j--) {
				if ( j + weight <= maxWeight) {
                    // 최대값 갱신
					dp[j+weight] = Math.max(dp[j+weight], dp[j] + value);
				}
			}
		}
		
		System.out.println(dp[maxWeight]);
		
		
	}
}
