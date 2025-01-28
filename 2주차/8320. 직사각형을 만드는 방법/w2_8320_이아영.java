import java.util.*;

// 못 풀었지만 ... 푼 곳까지 올림

//변의 길이 1인 정사각형 n개로 만들 수 있는 직사각형의 개수
//회전/이동해서 두가지가 안겹치면 '다른 직사각형'
//꼭 모든 정사각형을 다 써야하는 건 아님 (홀수면 -1할 수 있음)
//1줄2줄3줄 ... 줄(행)기준으로 생각
public class w2_8320_이아영 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int res = 0;
		
//		1줄이면 1*N개는 무조건 가능
//		2줄이면 2의 배수로 가능
//		3줄이면 3의 배수, n줄이면 n의 배수로 가능
//		1줄에서는 N*1개 무조건 가능 -> 개수는 N개
//		2*2, 2*3, 2*4보다 N이 많으면 가능 -> 4, 6, 8 ... > N이면 스탑
//		3*2는 2*3과 같은거니까, 3*3 3*4보다 N이 많으면 가능
//		i*j라 하면 j가 i보다 커야 가능
//		불가능 조건은 i*j를 초과하지 않을 때

		res += N; // 1줄일 때 무조건 N개
//		System.out.println("1줄일 때: " + N);
		// 줄을 i라고 하면
//		for (int i = 2; i <  ) {
//			for (int j = i; j < )
//				if (i * j )
//		}
		// for로 했더니 종료 조건을 모르곘음

//		int count = 0;
//		// 완전 안 되는 조건: i가 N에 도달하면 끝 (무조건 N*1이 최대값)
//		while (i <= N) {
//			System.out.println(i + "줄일 때:");
////			if (i * j < N) { // 얘보다 작으면 j 올리면서 계속 해보기
////
////			} 
//			while (i*j < N) {
//				System.out.println((i*j) + "보다 작다 1추가");
//				count += 1;
//				j++;
//			}
//			i++;
////			else { // 초과하면 i 올려서 다시 해보기
////				i++;
////			}
//
//		}
		int i = 2;
		int j = i;
		int c = 0;
		// i*j 곱하다가, 얘가 N을 초과하면 stop하기
		while (i * j < N) {
			while (i*j < N) {
				c += 1;
				j++; // j늘리기
			}
			c += 1;
			i++;
		}
		System.out.println(res + c);
//		System.out.println("Count:" + (res+count));
		sc.close();
		
	}
}
