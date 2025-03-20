import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class w9_28066_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            queue.add(i);
        }

        while(queue.size() > 1){
            queue.add(queue.poll());
            for(int i = 1; i < K; i++){
                if(queue.size() == 1) break;
                queue.poll();
            }
        }
        System.out.println(queue.poll());
    }
}
