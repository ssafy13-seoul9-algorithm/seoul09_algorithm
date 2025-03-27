import java.math.BigInteger;
import java.util.Scanner;

public class w10_10826_김우준 {
    static BigInteger[] arr;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new BigInteger[N+1];

        arr[0] =  BigInteger.ZERO;
        if(N > 0)arr[1] = BigInteger.ONE;

        System.out.println(fibo(N).toString());
    }

    public static BigInteger fibo(int n){
        if(arr[n] == null){
            arr[n] = (fibo(n - 1)).add(fibo(n - 2));
        }

        return arr[n];
    }
}
