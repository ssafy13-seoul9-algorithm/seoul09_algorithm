import java.util.Arrays;
import java.util.Scanner;

public class w11_16395_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int K = input[1];

        int[] arr = new int[N+1];
        arr[1] = 1;

        for(int i = 1; i <= N; i++){
            for(int j = i; j > 0; j--){
                // i행의 j위치의 값은 i-1번째 행의 j-1 + j
                // 좌표 압축해서 1차원 배열로
                arr[j] = arr[j] + arr[j-1];
            }
        }

        System.out.println(arr[K]);
    }
}