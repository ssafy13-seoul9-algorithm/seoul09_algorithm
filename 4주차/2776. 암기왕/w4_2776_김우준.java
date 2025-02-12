import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            br.readLine();
            Set<Integer> set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                set.add(Integer.parseInt(st.nextToken()));
            }
            br.readLine();
            st = new StringTokenizer(br.readLine());
            
            while(st.hasMoreTokens()){
                sb.append(set.contains(Integer.parseInt(st.nextToken())) ? "1\n" : "0\n");
            }

            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
}
