/* 못 풀었음ㅅ !!!!-!!! 
 "상태 동시에 변경" 이라는 말이 참 어려웠스요요
 * 톱니바퀴 4개, 각 톱니 8개씩 가짐, 회전 1회 (시계/반시계) 
 * 톱니A, 톱니 B 맞닿은 극 다르면 반대방향 회전, 같으면 회전X 
 * 연쇄적: 회전 시작하면 양쪽 극 확인
 *   극 같으면 회전 > 다음 톱니 극 검사
 *   극 다르면 회전X, 바로 확인 멈춤 
 * 회전 완료할 때마다 상태를 계속해서 저장장
 * K번 회전 완료한 후, 결과는 12시방향(idx 첫 번째) 점수로 계산 
 * 반시계방향 회전: 원소 1칸 왼쪽으로 밀기, 시계방향: 원소 1칸 오른쪽으로 밀기
 */
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 톱니바퀴 큐로 하면 편할 것 같은데..

public class Main {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    // 12시부터 시계방향 8개 / N극 0 S극 1
    int[][] wheels = new int[4][8];
    for (int i = 0; i < 4; i++){
      // \n 올 때까지 입력받기 
      String s = sc.nextLine();
      for (int j = 0; j < 8; j++){
        wheels[i][j] = s.charAt(j) - '0';
      }
    } // input 

    int K = sc.nextInt(); // 회전 횟수 

    // 1회전 종료 조건 > 톱니바퀴 1/4번까지 다 보거나 left or right와 극이 같은 경우
    for (int i = 0; i < K; i++){

      int target = sc.nextInt() - 1; // 회전시킨 톱니바퀴 번호 (0-based idx)
      // 원복 위해 tmp에 저장
      int tmp = target; 
      int direction = sc.nextInt(); // 1 시계방향, -1 반시계방향 
      boolean clockwise = direction == 1;
          

      // 왼쪽, 오른쪽 바퀴 가리키기 > target이 끝값일 때 사용 X
      int left = target - 1;
      int right = target + 1;
      boolean leftdir = !clockwise;
      boolean rightDir = !clockwise;


      // 양 끝을 돌릴지/말지 파악하는 건 실제 회전 수행 '전'
      // target 하나를 찍고 양옆 idx 먼저 비교한 후에 돌리기 

      // target 톱니 돌리기
      Deque<Integer> deque = new LinkedList<>();
      for (int j = 0; j < 8; j++){
        deque.add(wheels[target][j]);
      } 
      
      // 내 톱니는 direction대로 돌리기
      if (clockwise) deque.addFirst(deque.pollLast());
      else deque.addLast(deque.pollFirst());
      for (int j = 0; j < 8; j++){
        wheels[target][j] = deque.pollFirst(); // 순서대로 다시 넣기 
      } 
      deque.clear();

      // 회전 전 양쪽 값 검사: 맞닿은 값 다르면 회전수행, 같으으면 수행X
      // target 왼쪽과 검사: left[2] & target[6]
      while (left >= 0 && wheels[left][2] != wheels[target][6]) {
        // 왼쪽은 왼쪽으로만 돌리고 오른쪽은 오른쪽으로만 돌리고
        
        for (int j = 0; j < 8; j++){
          deque.add(wheels[left][j]);
        } 

        // 반대로 돌리기 
        if (leftdir) deque.addLast(deque.pollFirst());
        else deque.addFirst(deque.pollLast());
        
        for (int j = 0; j < 8; j++){
          wheels[left][j] = deque.pollFirst(); // 순서대로 다시 넣기 
        } 
        deque.clear();
        target = left;
        left--; 

        // * 돌리기 * 
        leftdir = !(leftdir);
      } // target 왼쪽 검사 

      // target 원복
      target = tmp;
      
      // target 오른쪽과 검사: right[6] & target[2]
      while (right <= 3 && wheels[right][6] != wheels[target][2]) {
        
        for (int j = 0; j < 8; j++){
          deque.add(wheels[right][j]);
        } 

        // 반대로 돌리기 
        if (rightDir) deque.addLast(deque.pollFirst());
        else deque.addFirst(deque.pollLast());
        
        for (int j = 0; j < 8; j++){
          wheels[right][j] = deque.pollFirst(); // 순서대로 다시 넣기 
        } 
        deque.clear();

        target = right;
        right++;

        // * 돌리기 * 
        rightDir = !(rightDir);
      } // target 오른쪽 검사
    }

      // 왼쪽이든 오른쪽이든 회전수행 한 후 상태 배열 업데이트
    // 점수 계산 > 각 바퀴 0번째 idx만 보기 (가중치 다름)
    int score = 0;
    // 각 행별로 0번째 원소에 값 곱하기 
    // 0행은 2^0, 1행은 2^1, 2행은 2^2, 3행은 2^3 점수 곱하기 > 비트시프트 연산 
    for (int i = 0; i < 4; i++){
      // 어차피 0 아니면 1
      score += wheels[i][0] * (1 << i);
    }
    System.out.println(score);

    sc.close();

  } // main
}
