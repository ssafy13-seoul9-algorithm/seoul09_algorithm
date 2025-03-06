import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static int[][] friend;
    static List<List<Integer>> friend2;
    static boolean[] visit;
    static int N;
    static int M;
    static int max;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        friend = new int[M][2];
        friend2 = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            friend2.add(new ArrayList<>());
        }
        visit = new boolean[N+1];
        max = Integer.MIN_VALUE;
        for(int i = 0; i < M; i++){
            input = sc.nextLine().split(" ");
            friend[i][0] = Integer.parseInt(input[0]);
            friend[i][1] = Integer.parseInt(input[1]);

            friend2.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            friend2.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }
        // 재귀 조합 탐색
        comb(0, 0);
        // comb2(0, new ArrayList<>());

        max *= 2;
        if(max < N){
            max++;
        }
        System.out.println(max);
    }

    static void comb(int idx, int cidx){
        if(idx >= M){
            max = Math.max(max, cidx);
            return;
        }

        if(visit[friend[idx][0]] || visit[friend[idx][1]]){
            comb(idx+1, cidx);
        } else {
            visit[friend[idx][0]] = true;
            visit[friend[idx][1]] = true;
            comb(idx+1, cidx+1);
            visit[friend[idx][0]] = false;
            visit[friend[idx][1]] = false;
            comb(idx+1, cidx);
        }

    }

    static void comb2(int idx, List<Integer> list){
        if(idx > N){
            max = Math.max(max, list.size());
            return;
        }

        if(friend2.get(idx).isEmpty()){
            comb2(idx+1, list);
            return;
        }

        boolean valid = true;
        for(int f : friend2.get(idx)){
            if(visit[f]){
                valid = false;
                break;
            }
        }

        if(valid){
            visit[idx] = true;
            list.add(idx);
            comb2(idx+1, list);
            list.remove(list.size() - 1);
            visit[idx] = false;
        }
        comb2(idx+1, list);
    }
}
