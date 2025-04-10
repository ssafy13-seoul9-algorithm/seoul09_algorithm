import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class w12_1138_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(i);
        }

        int[] result = new int[N];
        for(int i = 0; i < N; i++){
            int pos = list.remove(input[i]);

            result[pos] = i+1;
        }

        for(int num : result){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
