import java.util.Scanner;

public class w10_9657_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        boolean[] arr = N > 5 ? new boolean[N+1] : new boolean[6];

        arr[1] = true;
        arr[2] = false;
        arr[3] = true;
        arr[4] = true;
        //

        for(int i = 6; i <= N; i++){
            arr[i] = !arr[i-1] || !arr[i-3] || !arr[i-4];
        }

        System.out.println(arr[N] ? "SK" : "CY");
    }
}


// 1 -> 1
// 2 -> 1 1
// 3 -> 1 1 1
// 4 -> 4
// 5 -> 3 1 1
// 6 -> 4 1 1
// 7 -> 3 1 1 1 1
// 8 -> 4 1 1 1 1
// 9 -> 4 3 1 1

