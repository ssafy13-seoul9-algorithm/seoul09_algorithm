
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class w10_10826_김호정 {

    static BigInteger[] memo = new BigInteger[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));
    }

    static BigInteger fibo(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        }
        if (n == 1) {
            return BigInteger.ONE;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        return memo[n] = fibo(n - 1).add(fibo(n - 2));
    }
}
