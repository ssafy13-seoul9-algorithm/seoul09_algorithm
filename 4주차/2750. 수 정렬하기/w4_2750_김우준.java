import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < N - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    arr[j] ^= arr[j+1];
                    arr[j+1] ^= arr[j];
                    arr[j] ^= arr[j+1];
                }
            }
        }

        for(int i = 0; i < N; i++){
            System.out.println(arr[i]);
        }
    }
}