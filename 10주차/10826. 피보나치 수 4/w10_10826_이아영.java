import java.math.BigInteger;
import java.util.Scanner;

// 첨 써봄 : BigInteger 

public class Main {

  static BigInteger[] dp;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    // 1-based idx
    // dp = new BigInteger[N+1];
    // N=0인 경우 방지하기 위해 사용
    dp = new BigInteger[Math.max(2, N+1)];


    // dp 배열에 저장할 값은 n번째 피보 값 
    dp[0] = BigInteger.ZERO;
    // arrayidxofboundsexception: N=0일 경우 dp[0] 1개만 저장되기 때문 ! 
    dp[1] = BigInteger.ONE; 

    for (int i = 2; i <= N; i++){
      dp[i] = dp[i-1].add(dp[i-2]);
    }

    System.out.println(dp[N]);
    
    sc.close();
  }
}
