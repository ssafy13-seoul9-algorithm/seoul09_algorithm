import java.util.Scanner;

// 실패했으나 푼 곳까지 올림
public class w2_3985_이아영 {
  public static void main(String[] args) {
		// 롤케이크 길이
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt(); // 롤케이크 길이
		int N = sc.nextInt(); // 방청객 수
		// 롤케이크 배
		int[] arr = new int[L];
		// 방청객별로 원하는 수 p ~ k
		// N줄, p부터 k까지

		int m = 0; // 가장 ㅁ낳은 조각 기대한 방청객 
		// 방청객별 기대한 수 저장 
		int[] atc = new int[N];
		// 방청객별 실제 받은 수 저장  
		int[] rl = new int[N];
		// 롤케이크 배열에 직접저장 
		for (int i = 1; i <= N ; i++) {
			// 받은 수 배열 idx맞추기 위해 -1
			int P = sc.nextInt() - 1;
			int K = sc.nextInt() - 1;
			// p ~ k까지 저
			for (int j = P; j <= K; j++) {
				// 방청순서대로정렬 
				if (arr[j] == 0) {
					arr[j] = i;
					rl[i-1] += 1;
				}
				
			}
			
			// 배열순회하며 확인
			atc[i-1] = K - P + 1;
			m = i;

		}
//		m = 0;
		// 기대 방청 같은 경우 작은 수로 고정 
		for (int i = m; i < N-1; i++) {
			if (atc[m] == atc[m+1]) {
				m = i;//더 큰 값 찾으면 idx 갱
			}
		}
		
		// 실제 방청객 
		int rm = 0; // 실제 가장 많은 조각 받은 방청객 

		for (int i = 1; i < N-1; i++) {
			if (rl[rm] < rl[i]) {
				rm = i;//더 큰 값 찾으면 idx 갱
			}
		}
		
		System.out.println("많은 조각 기대");
		for (int i : atc) {
			System.out.println(i);
		}
		
		
		System.out.println("실제 조각 사람");

		for (int i : rl) {
			System.out.println(i);
		}


		System.out.println("문제 출력");

		System.out.println(m);
		System.out.println(rm+1); //idx+1
		sc.close();
	}
}
