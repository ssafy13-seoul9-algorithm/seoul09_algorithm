import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class w13_1806_이종환 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(stk.nextToken());
        int goalSum = Integer.parseInt(stk.nextToken());
        int[] arr = new int[size];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) arr[i] = Integer.parseInt(stk.nextToken());

        int minLen = Integer.MAX_VALUE;
        int st = 0,end = 0;
        int curSum = arr[0];

        while(true){
            if (curSum >= goalSum)  {
                minLen = Math.min(minLen, end-st+1);
                curSum -= arr[st];
                st++;
            } else {
                end++;
                if (end == arr.length) break;
                curSum += arr[end];
            }
        }

        System.out.println((minLen==Integer.MAX_VALUE)?0:minLen);
    }
}

