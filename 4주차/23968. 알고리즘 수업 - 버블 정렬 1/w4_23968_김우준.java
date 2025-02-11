import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int length = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        for(int i = 0; i < input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        int cnt = 1;
        outer: for(int i = 0; i < input.length - 1; i++){
            for(int j = 0; j < input.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    arr[j] ^= arr[j+1];
                    arr[j+1] ^= arr[j];
                    arr[j] ^= arr[j+1];
                    if(cnt++ >= K){
                        System.out.println(arr[j] + " " + arr[j+1]);
                        break outer;
                    }
                }
            }
        }

        if(cnt <= K){
            System.out.println(-1);
        }
    }
}
