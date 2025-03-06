package BFS;

import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        adj = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        visited = new boolean[N + 1];
        int maxBestie = 0;

        for (int i = 1; i <= N; i++) {
            maxBestie = Math.max(maxBestie, bfs(i));
        }

    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int cnt = 1;    // 처음 친구 크기는 1로 설정. 연결 하나도 안 되어 있어도 1명이니까.

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int friend : adj.get(node)) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    queue.add(friend);
                    cnt++;      // 친구 인원 수 증가
                }
            }
        }

        return cnt;
    }

}
