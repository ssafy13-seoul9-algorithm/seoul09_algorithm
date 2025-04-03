import java.util.*;

public class BJ12865 {
	// N개의 물건과 최대로 버틸 수 있는 무게 K를 설정한다.
	// 무게 W와 가치 V를 가진다.
	// 최대 K 만큼의 물건을 넣고 최대 즐거움 M을 구해라.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++){
			arr[i][0]= sc.nextInt();
			arr[i][1]= sc.nextInt();
		}

		// System.out.println(Arrays.deepToString(arr));

		// 각 무게 당 최대 만족도를 기록할 수 있는 배열을 만든다.
		int[] dp = new int[K+1];
        /*
        for(int i=0; i<N; i++){
            int weight = arr[i][0];
            int sat = arr[i][1];
            if(weight <= K){
                dp[weight] = Math.max(dp[weight], sat);
            }
        }*/

		//System.out.println(Arrays.toString(dp));
		//System.out.println("------------------");

		// 각 가방에서 고른 물건을 고려한다.
		// 각 물건을 한번씩만 고르기 위해서는 물건 고르는 for문을 밖에 작성해야 한다.
		for(int i = 0 ; i < N ; i++){
			int weight = arr[i][0];
			int value = arr[i][1];
			// 각 무게에서의 최대 만족도를 고려한다.
			// 물건을 한개씩 고를때마다 이전 물건을 골랐을 때의 최대 만족도가 담긴 dp배열을 새롭게 갱신하지 않기 위해서,
			// 갱신이 안된 왼쪽 값을 사용하기 위해 오른쪽에서부터 동일 무게에 대한 최대 만족도를 고려해야 한다.
			for(int j = K; j >= weight ; j--){
				// i 무게의 최대 만족도는, i무게 자체로 만든 최대 만족도 혹은 2개의 합으로 만든 만족도 중에서 큰 것을 고른다.
				// 2개를 고르는 것은 최종적으로 최대 무게 K를 만들기 위해서 t개(<K)를 선택할 수 있기 때문에, 반복해서 dp를 구하다보면 t개를 고를 수 있음 ㅋ
				dp[j] = Math.max( dp[j], value + dp[ j - weight ]);

				//System.out.println(Arrays.toString(dp));
			}

		}


		System.out.println(dp[K]);




	}
}

//4 7
//5 13
//3 8
//2 6
//4 12
