import java.util.Scanner;

public class w2_1592_이아영 {
  
//실패했으나 푼 곳까지 올림 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력 받기
		int N = sc.nextInt(); // 사람 수
		int M = sc.nextInt(); // 공 받은 수 (종료조건)
		int L = sc.nextInt(); // 공 전달할 사람 
		
		
		// 공 저장할 사람 수
		int[] arr = new int[N];
		
		
		// 누구 1명이 M번 도달전까지 게임진
		int i = 0; // 게임 시작은 0번
		arr[0] = 1; //초기값 
		int count = 0; // 공 이동 횟수

		
		// 종료 조건: 공 받은 사람 수가 M인지 검사 
		while(true) { 
			System.out.println("배열 확인");
			for (int c : arr) {
				System.out.print(c + " ");
			}
			System.out.println("");
			System.out.println("계산 시작");
			int res = arr[i] % 2;
			System.out.println(i + "번이 받은 수 " + arr[i]);
			
			// 1번이 공 던지기 시작 -> 1번은 무조건 시계방향으로 
			// 공 받은 횟수 홀수번이라면 시계
			if (res != 0) { 
				// idx이동 
				i = i + L; 
				if (i >= N) {
					i = i - N;
				}

				System.out.println("다음 idx" + i);

			// 공 받은 횟수 짝수번이라면 반시계  
			} else if (res == 0) { // 짝수번이라면 
				// 반시계방향으로 L번 -> i = i - L;
				i = i - L;
				if (i <= N) {
					i = i + N;
				} else if (i < 0) { //음수일 경
					i = N - i;
				}
				System.out.println("다음 idx" + i);
			}
			count++; 
			arr[i]++; 
			// 증감 후 종료조건 확인 
			if (arr[i] == M)
				break;
		}
		
//		System.out.println(count);
		
		
		
		sc.close();
	}
}