/* D배열: [4, 3, 1, 2, 5] -> idx [1, 2, 3, 4, 5]일 때
S[1] = P[D[1]], S[2] = P[D[2]]
S, D 이용해 P 만들기 위해서느
S[1] = P[D[1]]
 */

 import java.util.Scanner;

 public class Main {
     public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner(System.in);
 
         int N = sc.nextInt(); // 카드 개수
         int K = sc.nextInt(); // 카드 섞은 횟수 
 
         // k번 섞은 후 결과
         int[] S = new int[N];
         // 역셔플 저장할 임시 배열
         int[] P = new int[N];
         
         for (int i = 0; i < N; i++){
           S[i] = sc.nextInt();
         } 
 
         // 섞을 순서 수열 
         int[] D = new int[N];
         
         for (int i = 0; i < N; i++){
           D[i] = sc.nextInt();
         } 
 
         // 원래 수열에 저장, idx 이용해 돌리기
         // K번 돌리기
         for (int cnt = 0; cnt < K; cnt++){
           // 1회차 
           for (int i = 0; i < N; i++){
             // S[i]가 P에 저장될 원소값
             int val = S[i];
             int idx = D[i] - 1; // 저장할 idx (0-based로 돌리기)
             // P 배열 채우기 
             P[idx] = val;
           } // 회차 
 
           // 다음 순회 위해 S값도 덮어씌우기
           for (int i = 0; i < N; i++) S[i] = P[i];
         }
           
         // 출력
         for (int idx = 0; idx < P.length; idx++) {
             System.out.print(P[idx] + " ");
         }
 
 
         sc.close();
     }
 }
 