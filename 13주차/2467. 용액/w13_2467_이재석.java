import java.util.*;

public class BJ2467 {
	// 산성 용액, 알칼리 용액
	// 같은 양의 두 용액을 혼합해서, 특성값이 0에 가장 가까운 용액을 만드려고 한다.
	static int[] arr;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = sc.nextInt();
		}

		int[] result;
		result = findZero();

		//System.out.println(Arrays.toString(result));

		System.out.printf("%d %d", result[0], result[1]);

	}

	static int[] findZero(){
		int s = 0;
		int e = arr.length - 1;

		int min = Integer.MAX_VALUE;

		int[] result = new int[2];
		while( s < e){
			int sum = arr[s] + arr[e];
			int absSum = Math.abs(arr[s] + arr[e]);

			// 절대값의 합이 최소값보다 작을 때만, result 배열을 업데이트한다.
			if( absSum < min ){
				min = absSum;
				result[0] = arr[s];
				result[1] = arr[e];

			}
			// 2개 수의 합이 0보다 작다면, 음수 중 절대값이 더 작은 숫자를 넣는다.
			else if( sum < 0 ){
				s += 1;
			}
			// 2개 수의 합이 0보다 크다면, 양수 중 절대값이 더 작은 숫자를 넣는다.
			else if( sum > 0 ){
				e -= 1;
			}
			// 2개 수의 합이 0이라면, while문을 벗어난다.
			else{
				break;
			}
		}

		return result;
	}
}
