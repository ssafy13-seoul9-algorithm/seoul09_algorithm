
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class w9_28066_김호정 {
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            Deque<Integer> deque = new LinkedList<>();

            int N = sc.nextInt();
            int K = sc.nextInt();

            for (int i = 1; i <= N; i++) {
                deque.add(i);
            }

            while (deque.size() > 1) {

                for (int i = 1; i < K - 1; i++) {
                    deque.poll();
                }

                // 한 개만 남지 않는 경우는 지금 첫번째 요소 맨 뒤로 보내서 처음 값을 바꿔버림
                if (deque.size() >= K) {
                    deque.addLast(deque.pollFirst());
                }

            }

            System.out.println(deque.poll());

        }
    }
