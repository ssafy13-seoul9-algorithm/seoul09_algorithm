import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N명
		int K = sc.nextInt(); // 제거할 순서
		int M = sc.nextInt(); // M명 제거시마다 순서 돌리기
		
		// 덱으로 다시 풀어보기 
		
//		ArrayList<Integer> arr = new ArrayList<>();
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			dq.addLast(i); //사람 수 추가 
		}
		// 처음 지울 idx: K (사실 k+1번째 사람)
		int idx = K; 
		// 사람 제거될 때마다 count up 
		int cnt = 0; 
		// 사람 수 0 될 때까지 지우기 
		// 처음은 시계방향으로 제거 -> 반시계 -> 시계 돌아가기
		boolean clockwise = true;
		while(!dq.isEmpty()) {
			// 0부터 시작했으므로 출력할 사람 번호는 +1
			if (clockwise) {
				for (int i = 0; i < K-1; i++) {
					dq.addLast(dq.removeFirst());
				}
				// System.out.println(dq);
				System.out.println(dq.removeFirst());
//				sb.append(dq.peekFirst());
//				dq.removeFirst(); // kill 
			}
			// 반시계 
			else {
				for (int i = 0; i < K-1; i++) {
					dq.addFirst(dq.removeLast());
				}
				// System.out.println(dq);
				System.out.println(dq.removeLast());
//				sb.append(dq.peekLast());
			}
			
			// M번 돌았으면 반전 
			// size는 여전히 계속 1씩 감소... K만큼 뒤로 돌리기
			if (cnt == M) {
				clockwise = !clockwise;
				cnt = 0; // 카운트 초기화
			}
			
		} //제거 
		
		
	} // main
}
