import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class w5_11724_이종환 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodeCnt = Integer.parseInt(st.nextToken());
		int edgeCnt = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
		for (int i = 0 ; i <= nodeCnt; i++) {
			nodes.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < edgeCnt; i++) {
			st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			nodes.get(node1).add(node2);
			nodes.get(node2).add(node1);
		}
		
		boolean [] visited = new boolean[nodeCnt+1];
		visited[0] = true;
		
		int cnt = 0;
		
		loop:
		while(true) {
			
			for (int i = 1; i <= nodeCnt; i++) {
				if (!visited[i]) {
					Queue<Integer> q = new LinkedList<Integer>();
					visited[i] = true;
					q.add(i);
					while (!q.isEmpty()) {
						int target = q.poll();
						for (int node: nodes.get(target)) {
							if (!visited[node]) {
								visited[node] = true;
								q.add(node);
							}
						}
					}
					cnt++;
					continue loop;
				}
			}
			
			break;
		}
		
		System.out.println(cnt);
	}
}
