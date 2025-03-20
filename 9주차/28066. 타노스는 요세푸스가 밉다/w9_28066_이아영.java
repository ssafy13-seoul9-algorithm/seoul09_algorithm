import java.util.*;

/* 시계방향으로 K마리 청설모 선택, 1번째만 살려줌 > idx기준으로 덧셈연산, idx는 제거에서 제외
매 제거 회차마다 idx 갱신 / cnt 검사해야 함 
 */

public class Main {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // 청설모 총 수
    int K = sc.nextInt(); // 회차마다 청설모 제거할 수
    
    // 청설모 리스트를 ... 뭘로 받을까?
    Deque<Integer> squirrel = new LinkedList<>();
    // 사용 위해 list 객체 생성
    for (int i = 1; i <= N; i++){
      squirrel.offer(i);
    }
    
    // first 앞 last 뒤
    while(true){
      // 매 회차마다 종료 조건 검사
      // K마리보다 적게 남으면 제일 앞에 있는게 마지막 
      if (squirrel.size() < K) {
        System.out.println(squirrel.pollFirst());
        break;
      }
      // 첫 번째는 남겨주기
      int first = squirrel.pollFirst(); 
      // 첫 번째는 맨 뒤로 보내주기
      squirrel.addLast(first);
      
      // K마리 제거
      for (int i = 0; i < K-1; i++) {
        squirrel.pollFirst();
      }

    } // 제거 

    sc.close();
  }

}
