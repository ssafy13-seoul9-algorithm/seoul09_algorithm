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
        int cnt = 0;
        for(int i = 0; i < length; i++){
            int max = arr[0];
            int idx = 0;
            for(int j = 0; j < length - i; j++){
                if(arr[j] > max){
                    max = arr[j];
                    idx = j;
                }
            }
            if(arr[length - i - 1] != max){
                arr[idx] = arr[length - i - 1];
                arr[length - i - 1] = max;
                cnt++;
                if(cnt == K){
                    for(int n : arr){
                        System.out.printf("%d ", n);
                    }
                    break;
                }
            }
        }

        if(cnt < K){
            System.out.println(-1);
        }
    }
}