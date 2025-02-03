import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        int[] arr = new int[length+1];
        String[] input = sc.nextLine().split(" ");
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i-1]);
        }
        int cnt = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cnt; i++) {
            input = sc.nextLine().split(" ");
            int sex = Integer.parseInt(input[0]);
            int point = Integer.parseInt(input[1]);
            if (sex == 1) {
                for(int j = point; j < arr.length; j++){
                    if(j % point == 0){
                        arr[j] ^= 1;
                    }
                }
            } else {
                arr[point] ^= 1;
                for(int j = 1; j < arr.length/2; j++){
                    if(point-j > 0 && point+j < arr.length && arr[point+j] == arr[point-j]){
                        arr[point-j] ^= 1;
                        arr[point+j] ^= 1;
                    } else {
                        break;
                    }
                }
            }
        }
        for(int i = 1; i < arr.length; i++){
            System.out.print(arr[i] + " ");
            if(i % 20 == 0){
                System.out.println();
            }
        }
    }
}