import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int startIdx = Integer.parseInt(input[2]);
        boolean[] visited = new boolean[N + 1];

        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            arr.add(new ArrayList<>()); 
        }

        for(int i = 0; i < M; i++){
            input = sc.nextLine().split(" ");
            int lv = Integer.parseInt(input[0]);
            int rv = Integer.parseInt(input[1]);

            arr.get(lv).add(rv);
            arr.get(rv).add(lv);
        }

        for(List<Integer> list : arr){
            if(list != null) list.sort(Comparator.naturalOrder());
        }

        StringBuilder sb = new StringBuilder();
        visited[startIdx] = true;
        dfs(startIdx, arr, visited, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");
        
        Arrays.fill(visited, false);
        bfs(startIdx, arr, visited, sb);
        

        System.out.println(sb.toString());
        
    }

    static void dfs(int num, List<List<Integer>> arr, boolean[] visited, StringBuilder sb){
        sb.append(num + " ");
        for(int n : arr.get(num)){
            if(!visited[n]){
                visited[n] = true;
                dfs(n, arr, visited, sb);
            }
        }
    }

    static void bfs(int num, List<List<Integer>> arr, boolean[] visited, StringBuilder sb){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(num);
        visited[num] = true;

        while(!queue.isEmpty()){
            int k = queue.poll();
            sb.append(k + " ");
            for(int i = 0; i < arr.get(k).size(); i++){
                if(!visited[arr.get(k).get(i)]){
                    visited[arr.get(k).get(i)] = true;
                    queue.offer(arr.get(k).get(i));
                }
            }
        }
    }
}