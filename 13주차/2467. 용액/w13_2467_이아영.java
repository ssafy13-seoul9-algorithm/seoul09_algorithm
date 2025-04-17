/* 용액 첫번째부터 n번째까지 2개 전부 다 더해보고, 절댓값 가장 작은 것 구하기
 * 이진탐색은 mid 지정, 탐색범위 절반 쳐내기 (mid 지정 - 탐색범위 절반으로 줄이기)
 * 투포인터는 양끝단 or 좌에서 우로 탐색 (문제에서 주어진 조건 맞추기)
 * 전체 다 해봐야하니까 투포인터 사용하기 
*/

import java.util.Arrays;
import java.util.Scanner;
public class BOJ2467 {
    public static void main(String[] args) throws Exception {
      
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt(); // 용액 갯수
      int[] waters = new int[N];
      
      for (int i = 0; i < N; i++){
        waters[i] = sc.nextInt();
      }

      // 출력은 선택한 2개의 용액 - 0에 가장 가깝게 만들기 (정답 0 아닐수도잇슴 )
      int left = 0;
      int right = N - 1;
      
      // 정렬하면 0 아닌 지점 찾을 수 잇슴? 
      // -99 92 91 4 98 : 차이 보고 너무 커지면 멈추기~~? 
      Arrays.sort(waters);

      int val = Integer.MAX_VALUE;
      int target = 0;
      
      
      while (true){
        // 초기값 
        int crit = Math.abs(waters[left] + waters[right]);
        int val1 = Math.abs(waters[left + 1] + waters[right]);
        int val2 = Math.abs(waters[left] + waters[right - 1]);
        // 왼쪽 한 번 해보고 오른쪽 한 번 해보고 
        
        // 이번 값이 다음 값보다 작으면 이게 정답 
        if (val1 > crit && val2 > crit) {
          break;
        }
        
        // 값이 더 크다면 left ㄱㄱ 
        if (val1 < crit) left++;
        if (val2 < crit) right--;
      }

      System.out.println(waters[left] + " " + waters[right]);
      
      sc.close();
    
    }
}
