import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class w5_1260_이종환 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visitedDFS = new boolean[1001];
	static boolean[] visitedBFS = new boolean[1001];
	static Stack<Integer> stack = new Stack<Integer>();
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void dfs() throws IOException {
		int target = stack.pop();
		bw.append(target + " ");
		
		for (int i = 0; i < list.get(target).size(); i++) {
			int num = list.get(target).get(i);
			if ( !visitedDFS[num]) {
				visitedDFS[num] = true;
				stack.add(num);
				dfs();
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] rawInput = br.readLine().split(" ");
		
		int nodeCnt = Integer.parseInt(rawInput[0]);
		int edgeCnt = Integer.parseInt(rawInput[1]);
		int startNode = Integer.parseInt(rawInput[2]);

		
		for (int i= 0 ; i <= nodeCnt; i++) list.add(new ArrayList<Integer>());
		
		for (int i = 0; i < edgeCnt; i++) {
			String[] rawNodes = br.readLine().split(" ");
			
			int node1 = Integer.parseInt(rawNodes[0]);
			int node2 = Integer.parseInt(rawNodes[1]);
			
			list.get(node1).add(node2);
			list.get(node2).add(node1);
		}
		
		for (int i = 0; i < list.size();i++) {
		    Collections.sort(list.get(i), Comparator.naturalOrder());
		}

		
		stack.add(startNode);
		visitedDFS[startNode] = true;
		dfs();
		bw.append("\n");
		
		
		
		queue.add(startNode);
		visitedBFS[startNode] = true;
		while(!queue.isEmpty()) {
			int target = queue.poll();
			bw.append(target + " ");
			
			for (int i = 0; i < list.get(target).size(); i++) {
				int num = list.get(target).get(i);
				if ( !visitedBFS[num]) {
					visitedBFS[num] = true;
					queue.add(num);
				}
			}
		}
		
		bw.flush();
		
		
	}
}
