import java.util.*;

public class BJ18126 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.nextLine());

		// 노드 간 연결 관계를 나타내기 위한 코드
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for(int i=0; i <= N; i++){
			arr.add(new ArrayList<Integer>());
		}

		// 노드 간 거리를 나타내기 위한 코드
		long[][] dArr = new long[N+1][N+1];

		for(int i=1; i <= N-1; i++){

			int a = sc.nextInt();
			int b = sc.nextInt();
			arr.get(a).add(b);
			arr.get(b).add(a);

			long c = sc.nextLong();
			dArr[a][b] = c;
			dArr[b][a] = c;

			if(i<N-1)
				sc.nextLine();
		}

		//System.out.println(arr);
		//System.out.println(Arrays.deepToString(dArr));

		System.out.println(dfs(arr, dArr, 1, N));


	}

	// 아예 여기에서 거리를 반환하는 것이 좋은 방안일듯?
	static long dfs(ArrayList<ArrayList<Integer>> arr, long[][] dArr, int v, int N){
		boolean[] visited = new boolean[N+1];
		long[] distance = new long[N+1];

		Stack<Integer> s = new Stack<>();
		s.push(v);
		visited[v]= true;

		// 특정 노드까지의 거리를 계산하고, 최대값 관리를 위한 max 값을 형성한다.
		distance[v] = 0;
		long result = 0;

		while(! s.isEmpty()){
			// pop을 하는 경우에만, dis를 업데이트한다.
			int curr = s.pop();

			// System.out.printf("curr %d\n", curr);

			for(int node :arr.get(curr)){
				if(!visited[node]){
					visited[node] = true;
					// 현재 노드까지의 거리 + 현재 노드에서 이웃 노드까지의 거리
					distance[node] = distance[curr] + dArr[curr][node];
					s.push(node);

					// 현재 노드 + 현재 노드에서 이웃 노드까지의 거리 중 가장 큰 것을 업데이트 한다.
					if(result < distance[node])
						result = distance[node];
					// System.out.printf("node %d\n", node);
					// System.out.printf("Dis %d\n", distance[node]);
				}


			}

			// System.out.println(Arrays.toString(distance));
		}

		return result;

	}

//6
//1 2 3
//2 3 2
//2 4 4
//3 5 5
//3 6 7
}

