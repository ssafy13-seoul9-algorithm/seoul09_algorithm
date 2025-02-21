import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < M; i++){
            input = sc.nextLine().split(" ");
            int lv = Integer.parseInt(input[0]);
            int rv = Integer.parseInt(input[1]);

            List<Integer> lList = new ArrayList<>();
            if(map.containsKey(lv)){
                lList = map.get(lv);
            }
            lList.add(rv);
            map.put(lv, lList);

            List<Integer> rList = new ArrayList<>();
            if(map.containsKey(rv)){
                rList = map.get(rv);
            }
            rList.add(lv);
            map.put(rv, rList);
        }

        boolean[] visited = new boolean[N+1];
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(i, map, visited);
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    static void dfs(int num, Map<Integer, List<Integer>> map, boolean[] visited){
        visited[num] = true;
       if(map.get(num) != null){
            for(int v : map.get(num)){
                if(!visited[v]){
                    dfs(v, map, visited);
                }
            }
        }
    }
}
