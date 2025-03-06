import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class w7_15270_이종환 {
	static boolean[] visited;
	static int nodeCnt;
	static int edgeCnt; 
	static int max = 0;
	static ArrayList<Set<Integer>> nodes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		
		nodeCnt = Integer.parseInt(st.nextToken());
		edgeCnt = Integer.parseInt(st.nextToken());
		visited = new boolean[nodeCnt+1];
		visited[0] = true;
		
		nodes = new ArrayList<>();
		
		for (int i = 0; i <= nodeCnt; i++) {
			nodes.add(new HashSet<Integer>());
		}
		
		for (int i = 0; i < edgeCnt; i++) {
			st  = new StringTokenizer (br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			nodes.get(node1).add(node2);
			nodes.get(node2).add(node1);
		}
		
		dfs(0,1);
		
		if (max < nodeCnt) max++;
		System.out.println(max);
		
		
	}
	
	
	private static void dfs(int cnt, int idx) {
		max = Math.max(max, cnt);
		
		for (int i = idx; i <= nodeCnt; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			for (int node: nodes.get(i)) {
				if (visited[node]) continue;
				
				
				visited[node] = true;
				// 불필요한  for문을 안 돌리기위한 매개변수
				dfs(cnt+2,i+1);
				visited[node] = false;
			}
			visited[i] = false;
			
		}
	}
}