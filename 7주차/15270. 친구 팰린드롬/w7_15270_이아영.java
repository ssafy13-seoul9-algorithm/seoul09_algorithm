import java.util.*;

public class BOJ15270 {
//	static int cnt;
	static boolean[] visited;
	static List<ArrayList<Integer>> list;
	
	public static void main(String[] args) {
		// 총 반 친구 N(노드), 관계도 수 M(간선)
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		// 그래프 저장할 리스트
		list = new ArrayList<>();
		visited = new boolean[N+1];
		
		// 초기화
		for (int i = 0; i < N+1; i++) {
			// 1번부터 저장돼잇음 
			list.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			// 양방향 리스트
			list.get(n1).add(n2);
			list.get(n2).add(n1);
		} // input
		
		// 연결리스트 만들어짐
		// 접근법은 똑같지 않나
		// visited node면 다음부터 고려 X
		// 모든 원소에 대해 dfs 다 돌려보면?
		int max = 0;
		// arrays 전부 다 보기 
		for (int i = 1; i < N+1; i++) {
			int cnt = 0;
			for (int j = 0; j < list.get(i).size(); j++) {
				int start = j;
				cnt = dfs(start, 0);
			}
			max = Math.max(max, cnt);
		}
		// 근데 1에 연결된 원소가 없을 수도 있자나
		// 1번째 돌아보고 없으면 끝 ! 
		System.out.println(max);
		// 아무 시작 번호나 dfs 돌려보기 => 1번 기준으로 
		
		sc.close();
	}
	
	static int dfs(int start, int cnt) {
		// 탐색한 건 확인 꿍 
		visited[start] = true;
		cnt++; 
		
		// start 기준으로 연결된 배열 탐색
		for (int node: list.get(start)) {
			// node 기준으로 탐색 안 된 경우
			if (!visited[node]) {
//				System.out.println(node + "얘야");
				cnt = dfs(node, cnt);
			}
		}
		return cnt;
//		System.out.println("끝");
	} // dfs
}
