import java.util.Arrays;
import java.util.Scanner;

public class App {
    static int[] ans;
    static int[] res;
    static int pos;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ans = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        res = new int[10];

        check(0);
        System.out.println(pos);
    }

    public static void check(int idx){
        if(idx == 10){
            int cnt = 0;
            for(int i = 0; i < 10; i++){
                if(ans[i] == res[i]){
                    cnt++;
                }
            }
            if(cnt>=5) pos++;
            return;
        }

        for(int i = 1; i <= 5; i++){
            if(idx > 1){
                if(res[idx-1] == i && res[idx-2] == i) continue;
            }
            res[idx] = i;
            check(idx + 1);
        }
    }
}
