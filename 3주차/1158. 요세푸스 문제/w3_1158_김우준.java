import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> circle = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        for(int i = 1; i <= N; i++){
            circle.add(i);
        }

        int K = Integer.parseInt(input[1]);
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        for(int i = 0; i < N; i++){
            idx = (idx + K - 1) % circle.size();
            result.add(circle.remove(idx));
        }
        
        System.out.print("<");
        for(int i = 0; i < N; i++){
            System.out.print(result.get(i));
            if(i < N - 1) System.out.print(", ");
        }
        System.out.print(">");
    }
}
