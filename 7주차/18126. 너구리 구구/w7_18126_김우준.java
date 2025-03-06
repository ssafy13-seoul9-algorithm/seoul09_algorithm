import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    // 최대 거리 확인용 변수 선언
    static long maxDist;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        // 방문 확인용 배열 선언
        boolean[] isVisit = new boolean[N+1];
        // 노드간 거리를 확인해야 하므로 list<Map<>> 으로 선언
        List<Map<Integer, Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new HashMap<>());
        }

        for(int i = 1; i < N; i++){
            String[] input = sc.nextLine().split(" ");
            int lv = Integer.parseInt(input[0]);
            int rv = Integer.parseInt(input[1]);
            int dist = Integer.parseInt(input[2]);
            // 양방향 노드와 거리 삽입
            list.get(lv).put(rv, dist);
            list.get(rv).put(lv, dist);
        }

        // 입구는 항상 1이므로 1부터 제일 먼 거리 탐색
        dfs(1, list, 0, isVisit);

        System.out.println(maxDist);
    }

    static void dfs(int idx, List<Map<Integer, Integer>> list, long max, boolean[] isVisit){
        isVisit[idx] = true;
        // 현재 거리가 최대 거리보다 멀다면 갱신
        if(max > maxDist){
            maxDist = max;
        }
        // 현재 위치와 연결된 모든 노드 탐색
        for(int num : list.get(idx).keySet()){
            if(!isVisit[num]){
                dfs(num, list, max + list.get(idx).get(num), isVisit);
            }
        }
    }
}
