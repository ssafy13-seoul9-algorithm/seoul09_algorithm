import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] shuffle = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] tmp = new int[N];
        for(int i = 0; i < K; i++){
            for(int j = 0; j < N; j++){
                tmp[shuffle[j] - 1] = arr[j];
            }
            arr = Arrays.copyOf(tmp, N);
        }

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
