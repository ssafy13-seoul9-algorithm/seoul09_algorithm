import java.util.*;

public class BJ2193_New {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 각 N 자리 이친수의 끝자리를 기록하기 위한 count 배열을 만든다.
		long[][] count = new long[N+1][2];
		count[1][1] = 1;


		for(int i=1; i<N; i++){
			// i 자리 이친수의 끝자리가 1인 경우,
			// i+1자리 이친수에 0으로 끝나는 숫자 개수를 추가한다.
			count[i+1][0] = count[i][1];

			// i 자리 이친수의 끝자리가 0 일 경우,
			// i+1자리 이친수에 0과 1로 끝나는 숫자를 해당 숫자 개수만큼 추가한다.
			count[i+1][0] += count[i][0];
			count[i+1][1] += count[i][0];

		}

		// System.out.println(Arrays.deepToString(count));
		long result = 0;
		for(long ele: count[N]){
			result += ele;
		}

		System.out.println(result);

	}

}
