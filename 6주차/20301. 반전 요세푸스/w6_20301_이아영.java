import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// M명 제거될 때마다 제거할 방향 돌리기
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N명
		int K = sc.nextInt(); // 제거할 순서
		int M = sc.nextInt(); // M명 제거시마다 순서 돌리기
		
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			arr.add(i); //사람 수 추가 
		}
		// 처음 지울 idx: K (사실 k+1번째 사람)
		int idx = K-1;
		int cnt = 0; // 사람 제거될 때마다 count up 
		System.out.println(arr);
		
		// 사람 수 0 될 때까지 지우기 
		// 처음은 시계방향으로 제거 -> 반시계 -> 시계 돌아가기
		boolean clockwise = true;
		while(arr.size() != 0) {
			// 0부터 시작했으므로 출력할 사람 번호는 +1
			System.out.println(arr.get(idx));
			arr.remove(idx);
			cnt++; // 제거한 후 cnt up
			
			System.out.println(arr);
			// 다음 제거할 idx 결정 & size 하나씩 감소하게 되므로
			if (clockwise) {
				idx = (idx + K - 1) % arr.size();
			} else {
				
				idx = (idx - K) % arr.size();
				if (idx < 0) { // 음수로 떨어지면 
					idx = (idx - K + arr.size()) % arr.size();
				}
			}
			
			// M번 돌았으면 반전 
			// size는 여전히 계속 1씩 감소... K만큼 뒤로 돌리기
			if (cnt == M) {
				clockwise = !clockwise;
				cnt = 0; // 카운트 초기화
			}
			
		} //제거 
				
	}
}
