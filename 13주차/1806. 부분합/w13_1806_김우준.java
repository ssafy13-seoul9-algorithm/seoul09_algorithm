import java.util.Arrays;
import java.util.Scanner;

public class w13_1806_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int S = input[1];

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] arrSum = new int[arr.length+1];
        for(int i = 1; i < arrSum.length; i++){
            arrSum[i] = arrSum[i-1] + arr[i-1];
        }
        int result = Integer.MAX_VALUE;

        for(int i = 1; i < arrSum.length; i++){
            int lv = 0;
            int rv = i - 1;
            int res = -1;
            while(lv <= rv){
                int mid = (lv + rv) / 2;
                if(arrSum[mid] <= arrSum[i] - S){
                    res = mid;
                    lv = mid + 1;
                } else {
                    rv = mid - 1;
                }
            }
            if(res != -1) result = Math.min(result, Math.abs(i - res));
        }

        if(result == Integer.MAX_VALUE) result = 0;
        System.out.println(result);
    }
}

//
// 10 15
// 5 1 3 5  10 7  4  9  2  8
// 5 6 9 14 24 31 35 44 46 54
// 