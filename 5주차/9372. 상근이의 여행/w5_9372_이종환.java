import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class w5_9372_이종환 {
	public static void main(String args[]) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int tc = Integer.parseInt(br.readLine());
    	
    	for (int test_case = 1; test_case <= tc; test_case++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		int countryCnt = Integer.parseInt(st.nextToken());
    		int planeCnt = Integer.parseInt(st.nextToken());
    		
    		List<ArrayList<Integer>> nodes =  new ArrayList<>();
    		
    		for (int i = 0; i <= countryCnt; i++ ) {
    			nodes.add(new ArrayList<Integer>());
    		}
    		
    		for (int i = 0; i < planeCnt; i++) {
    			st =  new StringTokenizer(br.readLine());
    			int node1 = Integer.parseInt(st.nextToken());
    			int node2 = Integer.parseInt(st.nextToken());
    			
    			nodes.get(node1).add(node2);
    			nodes.get(node2).add(node1);
    		}
    		
    		boolean[] visited = new boolean[countryCnt+1];
    		
    		visited[1] = true;
    		
    		Queue<Integer> q = new LinkedList<Integer>();
    		
    		q.add(1);
    		
    		int cnt = 0;
    		
    		while(!q.isEmpty()) {
    			int cur = q.poll();
    			
    			for (int node: nodes.get(cur)) {
    				if (!visited[node]) {
    					q.add(node);
    					cnt++;
    					visited[node] = true;
    				}
    			}
    		}
    		System.out.println(cnt);
    	}
    	
    	

    }
}
