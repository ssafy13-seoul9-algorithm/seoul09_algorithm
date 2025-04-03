import java.math.BigInteger;
import java.util.Scanner;

public class w11_16395_이아영 {
   public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // n번째 행
		int K = sc.nextInt(); // k번째 수
		
		BigInteger[][] pascal = new BigInteger[N][N]; // N번쨰 행
		
		for (int i = 0; i < N; i++) {
			// 줄별로 떼서 보기 
			pascal[i][0] = BigInteger.ONE;
			// 1번째행에서 어차피 1로 덮어씌워짐
			pascal[i][i] = BigInteger.ONE;
			
			for (int j = 1; j < i; j++) {
				// 왼쪽위 + 바로위 
				pascal[i][j] = pascal[i-1][j-1].add(pascal[i-1][j]);
			}
		}
		System.out.println(pascal[N-1][K-1]);
		sc.close();
  }
}
