import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N;
            while(start<end){
                int mid = (start + end) / 2;; 
                if(arr[mid] < s){
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            int l = start;

            start = 0;
            end = N;
            while(start<end){
                int mid = (start + end) / 2;; 
                if(arr[mid] <= e){
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            int r = start;
            sb.append(r - l).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
