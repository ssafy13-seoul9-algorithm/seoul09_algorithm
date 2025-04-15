import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class w13_1939_이종환 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int nodeCnt, edgeCnt;
	static int[] parents;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(o.weight, weight);
		}
	}

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		nodeCnt = Integer.parseInt(st.nextToken());
		edgeCnt = Integer.parseInt(st.nextToken());
		parents = new int[nodeCnt+1];
		
		for (int i = 0; i <= nodeCnt; i++) parents[i]= i;
		
		for (int i = 0; i < edgeCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(from,to,weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int curMax = Integer.MAX_VALUE;
		
		while(!pq.isEmpty()) {
			if(find(start) == find(end)) break;
			
			Edge e = pq.poll();
			
			if (union (e.from, e.to)) curMax = Math.min(curMax, e.weight);
		}
		
		System.out.println(curMax);

	}
	
	private static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		if (aRoot < bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
		
		return true;
	}
	
	
	private static int find(int a) {
		if (a== parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	                                                                                                                                                                                                                                   
	
}
