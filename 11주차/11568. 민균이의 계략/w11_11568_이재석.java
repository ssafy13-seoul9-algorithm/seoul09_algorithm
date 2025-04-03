import java.util.*;

public class BJ11568 {
	// 순증가하는 수열이면서 원소의 개수가 가장 많은 수열을 만들어라.
	// 즉, 최장 증가하는 수열을 만들라는 뜻이다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = sc.nextInt();
		}

		//각 시작점에서 가장 긴 증가하는 수열을 구하기 위한 dp배열을 만든다.
		int[] dp = new int[N];
		Arrays.fill(dp, 1);

		// 각 i번째 항목에서 최장 증가하는 수열의 길이를 구한다.
		for(int i = 0; i < N; i++){
			// 각 i번째 항목에서 j번째 항목까지 j번째 항목이 더 크면,
			// 최장 증가하는 수열을 1만큼 더한다.
			for(int j = i; j < N; j++){
				if(arr[i] < arr[j]){
					dp[j] = Math.max(dp[j], dp[i]+1);
				}
			}
		}

		int max = -1;
		for(int i=0; i<N; i++){
			max = Math.max(dp[i], max);
		}
		// System.out.println(Arrays.toString(dp));
		System.out.println(max);

	}
}
