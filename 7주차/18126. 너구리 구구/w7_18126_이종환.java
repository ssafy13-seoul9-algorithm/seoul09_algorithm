import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class w7_18126_이종환 {
	//key: 연결된 노드 value: 그 노드와의 거리
	static ArrayList<Map<Integer,Integer>> nodes = new ArrayList<>();
	static boolean[] visited;
	static long max = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader ( System.in));
		int nodeCnt = Integer.parseInt(br.readLine());
		
		visited = new boolean[nodeCnt];
		
		for (int i = 0; i < nodeCnt; i++) {
			nodes.add(new HashMap<Integer,Integer>());
		}
		
		
		for (int i = 0; i < nodeCnt-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 0~n-1번 노드가 있는 걸로 간주
			int nodeA = Integer.parseInt(st.nextToken())-1;
			int nodeB = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			
			// 양방향 간선
			nodes.get(nodeA).put(nodeB, cost);
			nodes.get(nodeB).put(nodeA, cost);
		}
		
		visited[0] = true;
		dfs(0,0);
		System.out.println(max);
	}
	
	static void dfs(int target, long distance) {
		max = Math.max(max, distance);
		
		Map<Integer,Integer> targetInfo = nodes.get(target);
		
		for (int node: targetInfo.keySet() ) {
			if (!visited[node]) {
				visited[node] = true;
				dfs(node, distance + targetInfo.get(node));
				visited[node] = false;
			}
		}
	}
}