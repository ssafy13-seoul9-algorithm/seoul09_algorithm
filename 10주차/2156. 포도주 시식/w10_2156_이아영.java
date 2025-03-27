/* 포도주 N개 & 선택 개수 상관X but 연속 3잔까지는 불가능 & 최대로 많이 마시기
 * i: i번째 '포도주'까지 고려했을 때 -> dp[i] = i번째 포도주에서 가장 많이 마실 수 있는 양
 * 1, 2번을 마시는 선택을 했다면 -> 3번은 못 마심
 * ***cnt를 자꾸 같이 생각하지 말고, '이번 잔에서 고려 가능한 조합'을 선택하기 *****
 * 연속 3잔을 마시면 안 된다 == 연속 2잔까지는 괜찮다! 로 바꾸기 
 */

 import java.util.Scanner;

 public class Main {
   public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
 
     int N = sc.nextInt(); // 포도주 개수 
     int[] wines = new int[N+1];
     for (int i = 1 ; i <= N; i++){
       wines[i] = sc.nextInt();
     }
     int[] dp = new int[N+1]; // dp 테이블 
 
     // 초기값: 점화식 내에서 접근할 수 없는 범위 
     dp[1] = wines[1]; // 1번만 마시거나, 안 마시거나 중 '최대값' => 1번째 마시는 경우가 최대
     if(N >= 2) dp[2] = wines[1] + wines[2]; // 2번 마시거나, 안 마시거나 중 최대값 => 1번째 + 2번째가 최대 
 
     // dp[N]까지 돌았을 때 원하는 건 포도주 제일 많이 마실 수 있는 결과 
     // i번째 포도주까지 봤을 때 dp[i] = 가장 많이 마실 수 있는 경우.
     if (N >= 3){
       for (int i = 3; i <= N; i++){
         // 1. i번째 선택 않는 경우: 이전 상태 그대로 유지 (이번 잔 건너뛰기)
         int case1 = dp[i-1]; 
         
         // 2. i번째 선택하는 경우: 이전 상태에서 i번째 wine 추가
         // 2.1. i-1 & i 선택: i-2는 반드시 마시지 못함 
         // i-2가 포함되는 분기는 절대 고려X, 한 칸 뒤로 (i-3번째 상태가 비교 기준)
         int case2 = dp[i-3] + wines[i-1] + wines[i];
 
         // 2.2. i-2 & i 선택: i-1은 반드시 마시지 못함 
         // i-2번째까지 최댓값 + 현재값 
         // i-1번째 분기는 절대 고려X, 한 칸 뒤로 (i-2번째 상태가 비교 기준)
         int case3 = dp[i-2] + wines[i];
 
         dp[i] = Math.max(case1, Math.max(case2, case3));
       }
     }
 
     System.out.println(dp[N]);
 
     sc.close();
   }
 }
 