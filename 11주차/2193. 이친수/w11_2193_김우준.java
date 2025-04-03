import java.util.Scanner;

public class w11_2193_김우준 {
    static long[] arr;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        arr = new long[N+1];
        arr[1] = 1;
        // 마지막 수가 0이거나 1이거나 2가지 경우
        // 직전이 1이 아닌 0이거나 1이거나 2가지 경우
        if(N > 1){
            for(int i = 2; i <= N; i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
        }

        System.out.println(arr[N]);
    }
}
