
import java.util.*;

class Edge {

    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class b18126 {

    // 인접 간선 저장
    static ArrayList<Edge>[] adj;
    static boolean[] visited;   // 방문 여부 저장
    static int[] dist;          // 거리 저장

    public static void dfs(int start) {

        Stack<int[]> stack = new Stack<>();

        // 스택에 매개변수로 들어온 start 값을 넣어주기
        stack.push(new int[]{start, 0});

        // 스택에 아무것도 안 남을 때까지
        while (!stack.isEmpty()) {
            int[] curr = stack.pop(); // 스택에서 가장 위의 값 빼내기
            int node = curr[0];
            int distance = curr[1];

            if (visited[node] == true) {
                continue; // 방문한 곳은 pass
            } else { // 만약 방문하지 않았으면 해당 노드 방문 여부 true로 바꾸고 거리 저장
                visited[node] = true;
                dist[node] = distance;

            }

            for (int i = 0; i < adj[node].size(); i++) {
                Edge edge = adj[node].get(i);       // 현재 노드의 간선 for문 돌면서 가져옴
                if (!visited[edge.to]) {            // 방문 X 노드드
                    stack.push(new int[]{edge.to, distance + edge.weight}); // 스택에 추가
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        adj = new ArrayList[n + 1]; // 노드는 1부터 시작해서 0은 그냥 비워두기 때문에 배열 크기 +1

        for (int i = 1; i <= n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n + 1; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            adj[A].add(new Edge(B, C));
            adj[B].add(new Edge(A, C));
        }

        if (n == 1) {   // 노드 1개밖에 없으면 그냥 길이 0
            System.out.println(0);
            return;
        }

        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, dist[i]);
        }

        System.out.println(maxDistance);
    }
}
