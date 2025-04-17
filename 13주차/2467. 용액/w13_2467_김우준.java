import java.util.Arrays;
import java.util.Scanner;

public class w13_2467_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lv = 0;
        int rv = arr.length - 1;

        int numA = 0;
        int numB = 0;
        int min = Integer.MAX_VALUE;

        while(lv<rv){
            int sum = arr[lv] + arr[rv];
            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                numA = arr[lv];
                numB = arr[rv];
            }
            if(sum > 0){
                rv--;
            } else {
                lv++;
            }
        }

        System.out.println(numA + " " + numB);
    }
}
