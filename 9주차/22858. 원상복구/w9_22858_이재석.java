import java.util.*;

public class BJ22858 {
	// 1~N

	//  1,  4,  5,  3,  2

	// D1, D2, D3, D4, D5
	// 4번째 카드를, 1번째로 가져온다.
	// 3번째 카드를, 2번째로 가져온다.
	//  4,  3,  1,  2,  5

	//  3,  5,  1,  4,  2

	// 카드 개수, 섞은 횟수
	// K 번 섞은 후 카드의 배치
	// Di가 공백으로 주어진다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() ;
		int M  = sc.nextInt() ;
		sc.nextLine();

		int[] afterIntArr = new int[N];
		for(int i=0; i<N; i++ ){
			afterIntArr[i] = sc.nextInt();
		}
		sc.nextLine();
		// System.out.println(Arrays.toString(afterIntArr));

		// idx 기준으로 저장한다.
		int[][] DStrIntArr = new int[N][2];
		for(int i=0; i < N; i++ ){
			DStrIntArr[i][0] = sc.nextInt()-1;
			DStrIntArr[i][1] = i;

		}
		sc.nextLine();

		// System.out.println(Arrays.deepToString(DStrIntArr));

		int[] beforeIntArr = new int[N];
		// 주어진 횟수만큼 반복한다.
		for(int i = 0; i < M; i++){
			// 섞기 전 배열을 구한다.
			for(int j = 0; j < N; j++){
				beforeIntArr[DStrIntArr[j][0]] = afterIntArr[DStrIntArr[j][1]];
			}
			// 해당 과정을 반복하기 위해서 beforeIntArr의 값을 afterInt에 넣는다.
			afterIntArr = beforeIntArr.clone();
			// System.out.println(Arrays.toString(afterIntArr));

		}

		// System.out.println(Arrays.toString(beforeIntArr));
		for(int i:beforeIntArr){
			System.out.printf("%d ",i);
		}


		//   1    4    5 3 2

		// [3,0] [2,1] 0 1 4
		// 3       5   1 4 2

		// [3,0] [2,1] 0 1 4
		// 4   1  3  5  2

	}

}
