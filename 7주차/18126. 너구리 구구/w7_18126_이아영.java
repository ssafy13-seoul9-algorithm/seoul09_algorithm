import java.util.*;
public class Main {
	public static long maxLen;
	public static boolean[] visited;
	public static List<ArrayList<int[]>> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 1번 root 기준 가장 깊이 탐색 -> dfs인듯
		// 최대한 깊게 들어갈 수 있는 모든 경우의 수 전부 확인
		// 노드별로 가장 깊이 들어간 값 누적해서 최대값 찾아내기
		
		// root: 1, 1 기준으로 얼마나 깊이 들어가건 최대값만 있으면 댐 
		// 인접리스트로 연결상태 확인
//		List<ArrayList<Integer>> list = new ArrayList<>();
		
		// 거리 상태는 어떻게 저장할지 지선생에게 물어봄 > (노드, 거리) 쌍 받기 
		list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<int[]>());
		} // initialize (1-based idx)
		
		// 거리 저장은 어떻게?? > 배열로 
		for (int i = 0; i < N-1; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			int length = sc.nextInt(); // node1, node2 사이 거리
			
			// 1 연결상태 확인 & 2 node 간 거리 확인 
			// 양방향 연결
			list.get(node1).add(new int[] {node2, length});
			list.get(node2).add(new int[] {node1, length});
		} // graph edge
		
		visited = new boolean[N+1];
		// root node 1 기준으로 dfs 수행 & 최대 length 찾기
		// 시작노드, 누적 거리
		dfs(1, 0);
		
		System.out.println(maxLen);
		
		sc.close();
	}
	
	// 지피티 도움받음 
	public static void dfs(int curr, long length) {
		// root node 시작으로 탐색 수행 > 방문 체크 
		visited[curr] = true;
		// 최대값 업데이트 
		maxLen = Math.max(maxLen, length);
		
		// 노드 인접리스트 기반 다음노드 선택
		for (int[] next: list.get(curr)) {
			// 배열에 다음노드, 노드와 거리 저장되어있음 
			int nextNode = next[0];
			int nextDist = next[1];
			
			// 인접리스트로 하나씩 찾아서 들어가기 
			if (!visited[nextNode]) {
				dfs(nextNode, length + nextDist); 
			}
		}
	}
}
