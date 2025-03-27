import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class w10_17212_김우준 {
    static int[] choices = {1, 2, 5, 7};
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        list.add(0);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(1);

        for(int i = 8; i <= N; i++) {
            int min = N;
            for(int n : choices){
                min = Math.min(min, list.get(i-n));
            }
            list.add(min + 1);
        }

        System.out.println(list.get(N));
    }
}

// 1 -> 1
// 2 -> 2
// 3 -> 2 1
// 4 -> 2 2
// 5 -> 5
// 6 -> 5 1
// 7 -> 7