import java.util.*;

public class BJ28066 {
    // 1 ~ N
    // 5 4
    // Array로 풀면 빡세니까, Queue를 이용해서 풀자.
    // 12345
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            q.add(i+1);
        }

        int result = -1;
        while(true){
            if(q.size()>=K){
                // 첫번째 청솔모를 임시로 빼둔다.
                int temp = q.poll();
                // K-1마리의 청솔모를 제거한다.
                for(int i = 0; i < K-1; i++){
                    q.remove();
                }
                // 다시 Queue의 끝에 임시로 빼둔 청솔모를 다시 넣는다.
                q.add(temp);
            }else{
                // 마지막으로 남은 청솔모를 답으로 출력한다.
                int temp = q.poll();
                result = temp;
                break;
            }

        }

        // System.out.println(q);
        System.out.println(result);

        // 1 2X 3X 4X 5 6 7
        // 4


    }
}
