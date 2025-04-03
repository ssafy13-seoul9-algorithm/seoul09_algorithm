import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp,arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		arr = new int[size];
		dp = new int[size];
        Arrays.fill(dp,1);
        
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) arr[i] = Integer.parseInt(st.nextToken());
		for (int i =0 ; i< size; i++) getDp(i);

        int max = 0;
        for (int i = 0; i < size; i++) max = Math.max(max, dp[i]);
        

        System.out.println(max);
	}

    private static void getDp(int idx){
        for (int i = 0; i < idx; i++){
            if (arr[i] < arr[idx]) dp[idx] = Math.max(dp[idx], dp[i] +1);
        }
    }
}