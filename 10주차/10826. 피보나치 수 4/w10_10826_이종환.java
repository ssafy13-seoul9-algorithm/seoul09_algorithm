import java.math.BigInteger;
import java.util.Scanner;

public class w10_10826_이종환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger[] arr = new BigInteger[10001];
		arr[1] = BigInteger.ONE;
		arr[0] = BigInteger.ZERO;
		for (int i = 2; i<= 10000; i++) arr[i] = arr[i-1].add(arr[i-2]);
		
		System.out.println(arr[sc.nextInt()]);
	}
}