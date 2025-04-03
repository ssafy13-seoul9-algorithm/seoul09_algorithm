import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class w11_25343_이종환 {
    static int[][] dp,arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		arr = new int[size][size];
		for (int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[size][size];
		for (int i =0 ; i< size; i++) {
			Arrays.fill(dp[i],1);
			for (int j = 0; j < size; j++) {
                getDp(i,j);
			}
		}

        int max = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
	}

    private static void getDp(int y, int x){
        for (int i = 0; i <= y; i++){
            for (int j = 0; j <= x; j++){
                if (arr[i][j] < arr[y][x]) dp[y][x] = Math.max(dp[y][x], dp[i][j]+1);
            }
        }
    }
}