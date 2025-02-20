import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class w5_2606_이종환 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visitedBFS = new boolean[1001];
	static Queue<Integer> queue = new LinkedList<Integer>();

	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nodeCnt = Integer.parseInt(br.readLine());
		int edgeCnt = Integer.parseInt(br.readLine());;
		
		for (int i= 0 ; i <= nodeCnt; i++) list.add(new ArrayList<Integer>());
		
		for (int i = 0; i < edgeCnt; i++) {
			String[] rawNodes = br.readLine().split(" ");
			
			int node1 = Integer.parseInt(rawNodes[0]);
			int node2 = Integer.parseInt(rawNodes[1]);
			
			// 양방향으로 연결
			list.get(node1).add(node2);
			list.get(node2).add(node1);
		}
	
		
		// 1번에서 시작
		queue.add(1);
		visitedBFS[1] = true;
		
		
		// 이 큐가 끝나면 1번과 연결되어있는 모든곳은 visited == true가 됨
		while(!queue.isEmpty()) {
			int target = queue.poll();
			
			for (int i = 0; i < list.get(target).size(); i++) {
				int num = list.get(target).get(i);
				if ( !visitedBFS[num]) {
					// 방문하지 않은 지점이면 추가
					visitedBFS[num] = true;
					queue.add(num);
				}
			}
		}
		
		int ans = 0;
		
		for (int i = 2; i <= nodeCnt; i++) {
			if (visitedBFS[i]) ans++;
		}
		
		System.out.println(ans);
		
		
	}
}
