import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        Deque<Integer> deque = new ArrayDeque<>();

        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = sc.nextInt();

        for(int i=1; i<=N; i++){
            deque.add(i);
        }

        boolean dir = true; // true면 원래대로, false면 반대로
        int cnt = 0;    // 몇 번 제거됐는지 셀 변수
        while(!deque.isEmpty()){
            
            if(cnt > 0 && cnt % (M-1) == 0){
                dir = !dir;
            }
            for(int i=0; i<K-1; i++){
                
                if(dir == true) deque.addLast(deque.pollFirst());   // K-1번째까지 숫자를 맨 뒤로 보내버림
                else deque.addFirst(deque.pollLast());
            }
            System.out.println(deque.pollFirst());  // K번째 출력
            cnt++;

        }


    }
}
