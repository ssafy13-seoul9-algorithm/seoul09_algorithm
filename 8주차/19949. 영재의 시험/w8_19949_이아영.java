import java.util.*;

/* 1 전체 나올 수 있는 모든 경우 생성 (완탐시 5의 10승)
 * 2 나올 수 있는 수들 중, 같은 수 3개 이어서 나오면 전부 처리 (백트래킹)
 * 3 입력받은 정답배열과 비교
 * 4 5개이상 맞으면 cnt up
 * */

public class Main {
	
	static int[] arr = {1, 2, 3, 4, 5};
	static int N = arr.length;
	static int[] sel = new int[10];
	static int total = 0;
	static int[] ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 종료 조건 & 재귀 조건 설정 어떻게?
		// 종료 조건 > sel이 전부 차거나, 끝까지 다 보거나
		// 정답 배열 입력받기
		ans = new int[10];
		for (int i = 0; i < 10; i++) {
			ans[i] = sc.nextInt();
		}
		
		// 재귀 돌려 
		recur(0);
		System.out.println(total);
		
		sc.close();
	}
	
	// 완전탐색 먼저 구현 + 백트래킹 코드 추가
	static void recur(int sidx) {
		// 종료 조건 > 정답배열 10개 다 채워졌으면 정답 후보 배열 1줄 완성
		if (sidx == sel.length) {
			// 해당 배열 점수 검사
			check(sel);
			
//			System.out.println(Arrays.toString(sel));
			return;
		}
		
		// 재귀 조건 > res를 끝까지 채워
		for (int i = 0; i < N; i++) {
			sel[sidx] = arr[i]; // 배열 하나씩 채우기
			
			// sidx 2번부터만 검색 가능
			// 현재 판단하는 sidx 기준으로 -2번째, -1번째 모두 확인
			// 0 == 1 && 1 == 2이면 3개 연속 같은거니까 재귀X (백트래킹??)
			if (sidx >= 2) {
				if (sel[sidx-2] == sel[sidx-1] && sel[sidx-1] == sel[sidx]) {
					continue;
				}
			}
			
			// 다음번 배열 채우기
			recur(sidx+1); 
		}
	}
	
	// 정답배열과 맞는지 체크 
	static void check(int[] sel) {
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			// 정답지 & 현재 만들어진 배열과 비교 
			if (ans[i] == sel[i]) {
				cnt++;
			}
		} // 10개 모두 검사
		
		if (cnt >= 5) total++;
	}
}
