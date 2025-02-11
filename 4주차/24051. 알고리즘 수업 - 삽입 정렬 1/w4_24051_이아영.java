import java.util.Scanner;

// 배열 A에 k번째 저장되는 수
// 삽입 -> 1) 값 밀고 변경할 때, 2) 밀고난 후 마지막 idx에 key 넣을 때 
public class w4_24051_이아영 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 배열 A의 크기
		int N = sc.nextInt(); 
		int[] A = new int[N];
		
		// 저장 횟수
		int K = sc.nextInt();
		// 배열에 저장
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int cnt = 0; // 저장 횟수, K와 비교
		
		// 삽입정렬 구현
		for (int i = 1; i < N; i++) {
			int key = A[i]; // 비교할 값
//			int j = i-1; // 비교할 값의 이전 idx
			
			// j는 0부터 i-1까지, 이전 값이 key보다 크면 삽입연산 수행
			// 이전 값과 비교해서 이전인덱스의 값이 크면 오른쪽으로 '밀기'연산 
			// while 버리고 for로 했더니 되넹
			int j = i-1;
			for (; j >= 0; j--) {
				if (A[j] > key) { // key값보다 크면 값 저장 - 삽입연산 1
					A[j+1] = A[j];
					cnt++;
					if(cnt == K) {
						System.out.println(A[j+1]);
						break;
					}
					j--;
				}
			} // 반복 다 돈 후, 가장 가장 마지막 idx에 key 삽입 
				
			A[j+1] = key; // 다시 삽입연산 2
			cnt++; // 삽입연산2

			// count 수가 K와 일치하는 순간 break, 이동한 값 저장 
			if (cnt == K) {
				System.out.println(A[j+1]); 
				break;
			}
		}
		
		if (cnt < K) {
			System.out.println(-1);
		}
		
		
		sc.close();
	}
}
