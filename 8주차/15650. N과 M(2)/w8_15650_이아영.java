import java.util.*;

public class Main {
	static int[] arr; // 원본 배열 
	static int N;
//	static boolean[] visited;
	static int[] res;
	static int M;
	
	// n개 중 r개 조합 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 초기화 
		arr = new int[N];
		res = new int[M];
//		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		} // arr 채우기 
		
		comb(0, 0); // 0번부터 확인 
		
		// 1부터 N까지 자연수 중, 중복 없이 M개 고른 순열 
		// 오름차순으로 출력 -> swap방식 X
		sc.close();
	}
	
	// visited 배열 이용 
	static void comb(int idx, int sidx) {
		// 전부 다 확인했으면
		if (sidx == M) {
			// 출력
			for (int i = 0; i < M; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		// 다 도달하면 
		if (idx == N) return;
		
		// idx ~ arr, sidx ~ res
		// 포함하기 + 포함하지 않기
		res[sidx] = arr[idx];
		
		// 포함하기
		comb(idx+1, sidx+1);
		// 포함안하기
		comb(idx+1, sidx);
	}
}
