/* 6줄 패키지 or 낱개의 줄, 돈 최소한으로 사용
 * 줄이 남아도 됨! 돈만 적게 쓴다면 꼭 맞출 필요 X
 * 패키지 N개 vs 패키지 + 낱개 비교해서 최소금액으로 ㄱㄱ */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 사야 하는 줄 수 
		int N = sc.nextInt();
		// 기타줄 브랜드 M개
		int M = sc.nextInt(); 
		
		// 브랜드별 패키지 가격 + 낱개 가격 M쌍
		int[][] brands = new int[M][2]; // [0] 패키지 [1] 낱개
		
		
		// 꼭 한 브랜드에서만 살 이유 X면
		
		// 1 6개 줄 가장 싼 브랜드에서 구매
		// 2 나머지 낱개 줄 가장 싼 브랜드에서 구매 
		// 각각 가장 금액 작은 것 확인하기 
		int minPkgVal = Integer.MAX_VALUE;
		int minEachVal = Integer.MAX_VALUE;
		int minPkgIdx = 0;
		int minEachIdx = 0; 
		
		for (int i = 0; i < M; i++) {
			brands[i][0] = sc.nextInt(); // pkg 
			brands[i][1] = sc.nextInt(); // each 
			
		} // input
		
		for (int i = 0 ; i < M; i++) {			
			if (brands[i][0] < minPkgVal) {
				minPkgIdx = i;
				minPkgVal = brands[i][0];
			}
			if (brands[i][1] < minEachVal) {
				minEachIdx = i;
				minEachVal = brands[i][1];
			}
		}
		// pkg 6줄
		int pkg = 0;
		int each = 0;
		
		// 1 pkg만 구매
		int case1 = ((N / 6) + 1) * brands[minPkgIdx][0];
		
		// 2 each만 구매 
		int case2 = N * brands[minEachIdx][1];
		
		// 3 pkg + each
		if (N > 6) {
			pkg = N / 6;
			each = N - (pkg * 6); 
		} else {
			each = N;
		}
		
		int case3 = pkg * brands[minPkgIdx][0] + each * brands[minEachIdx][1];
		
		System.out.println(Math.min(case1, Math.min(case2, case3)));
		
		sc.close();
	}
}
