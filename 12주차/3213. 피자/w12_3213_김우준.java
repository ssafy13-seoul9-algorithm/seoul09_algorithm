import java.util.Arrays;
import java.util.Scanner;

public class w12_3213_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        int[] cnt = new int[4];
        for(int i = 0; i < N; i++){
            int[] input = Arrays.stream(sc.nextLine().split("/")).mapToInt(Integer::parseInt).toArray();

            if(input[1] == 2) cnt[2]++;
            else {
                if(input[0] == 1) cnt[1]++;
                else cnt[3]++;
            }
        }

        int min = 0;
        
        if(cnt[3] > 0){
            min += Math.min(cnt[1], cnt[3]);
    
            cnt[1] -= min;
            cnt[3] -= min;

            if(cnt[3] > 0) min += cnt[3];
        }


        min += cnt[2] / 2;
        
        if(cnt[2] % 2 > 0){
            min += 1;

            min += (cnt[1] - 2) / 4;
            if((cnt[1] - 2) % 4 > 0){
                min += 1;
            }
        } else {
            min += cnt[1] / 4;
            if(cnt[1] % 4 > 0){
                min += 1;
            }
        }
        System.out.println(min);
    }
}
