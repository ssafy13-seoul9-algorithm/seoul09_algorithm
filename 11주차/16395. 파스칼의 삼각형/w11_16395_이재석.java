import java.math.BigInteger;
import java.util.*;

public class BJ16395 {
	public static void main(String[] args) {
		// N번째 행에 N개의 수
		//        1
		//      1   1
		//    1   2  1
		//   1  3   3  1
		//  1  4  6  4  1
		// 1  5  10  10  5  1

		// N-1 C R-1 + N-1 C R = N C R
		// N C R = N * (N-1) * (N-2) ... R 개 / R !

		// 5C3 = 4C2 + 4C3
		// 4C2 = 3C1 + 3C2
		// 3C2 = 2C1 + 2C2

		// N 번째 행에 있는 K번째 수를 구한다.
		// 1, [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]

		Scanner sc = new Scanner(System.in);
		BigInteger I = sc.nextBigInteger();
		BigInteger M = sc.nextBigInteger();

		BigInteger N = I.subtract(BigInteger.ONE);
		BigInteger R = M.subtract(BigInteger.ONE);

		BigInteger ans = fact(N).divide((fact(N.subtract(R)).multiply(fact(R))));


		System.out.println(ans);

		// System.out.println(fact(3));



	}

	static BigInteger fact(BigInteger n){
		// Base Case
		if(n.compareTo(BigInteger.ONE) <= 0){
			return BigInteger.ONE;
		}

		// Recursive Case
		return n.multiply(fact(n.subtract(BigInteger.ONE)));
	}

}
