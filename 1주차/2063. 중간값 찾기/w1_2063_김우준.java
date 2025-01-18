import java.util.Scanner;
import java.util.Arrays;

public class w1_2063_김우준 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(arr[len / 2]);
    }
}