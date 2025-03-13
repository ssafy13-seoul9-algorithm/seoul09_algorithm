import java.util.*;

/*
 * k개 수 골라 집합 S 만들기 
 * */

public class Main {
	
	static int[] S;
	static int K; 
	static int[] res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 마지막 줄 0 하나일 때까지 입력받기
		while (true) {
			K = sc.nextInt();
			if (K == 0) break;
			
			res = new int[6];
			
			// k개 집합 입력받기 
			S = new int[K];
			for (int i = 0; i < K; i++) {
				S[i] = sc.nextInt();
			}
			
			
			// k개 중 6개 중복 없이 고르고 오름차순 
			// 조합 ! 
			comb(0, 0);
			System.out.println();
			
		}
		sc.close();
	}
	
	// 조합 재귀로 구현 
	static void comb(int idx, int sidx) {
		// 종료: 다 돌았을 때, 배열 채워졌을 때 
		if (sidx == 6) {
			for (int i : res) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		if (idx == K) return;
		
		// 재귀: 선택 or 미선택 
		res[sidx] = S[idx];
		
		comb(idx+1, sidx+1);
		comb(idx+1, sidx);
	}
}
