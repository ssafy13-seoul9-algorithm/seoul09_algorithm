import java.util.*;

// 소문자/대문자로만 이루어진 길이가 n인 단어
// 한 줄에 10글자씩 끊어서 출력
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 문자열 받기
		String st = sc.next();
		int N = st.length(); // 문자열 길이
		
		// 행 R개, 열 C개인 행렬
		// R * C = N, 여러 경우라면 R이 큰 것 
		int R = 0;
		int C = 0;
		
//		1. R / C의 값 구하기
//		1. 약수가 1/본인밖에 없으면(소수면) R = 1, C = N
//		2. 약수 쌍 중 R-C가 가장 작은 값 찾기
//		약수: 어떤 수를 나머지 없이 나눌 수 있는 '자연수'
//		R <= C
		for (int i = 1; i <= N; i++) {
			// i, j 안겹치게 돌리기
			for (int j = i; j <= N; j++) {
				if (i * j == N) {
//					System.out.print(i + " " + j);
//					System.out.println();
					// 어차피 배열 다 돌고 가장 마지막 값 저장됨
					R = i;
					C = j;
				}
					
			}
		}
//		System.out.println("R:" + R);
//		System.out.println("C:" + C);

		// 값 저장할 배열
		// R, C 결정된 후 초기화!
		char[][] arr = new char[R][C];
		
		
		String res = "";// 해독 문자열
		// 2. 2차원배열 돌면서 계산하기
//		해독: 암호문 글자를 1열부터 아래로 내려가면서 (행만 +)
//		0은 00에, 1은 10에, 2는 20에 ... 행 먼저 증가해야 함
//		행 안쪽 이중for문
		int idx = 0; // st 다룰 제어변수 - 0부터 max까지
		for (int i = 0; i < C; i++) { // 열
			for (int j = 0; j < R; j++) { // 행
//					st는 0 ~ N까지 순서대로 입력
				// idx가 길이 초과하지 않게
				if (idx < N) {
					arr[j][i] = st.charAt(idx);
					idx++;	
				} 
			}
		}

		// 결과 str에 행렬 원래대로 값 저장
		for (char[] c : arr) {
			for (char a : c) {
				res += a;
			}
		}
		
//		for (char[] c : arr) {
//			for (char a : c) {
//				System.out.print(a + " ");
//			}
//			System.out.println();
////			System.out.println(c + " ");
//		}
		
		System.out.println(res);
		sc.close();
		
	}
}