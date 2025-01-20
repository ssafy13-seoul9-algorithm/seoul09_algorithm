import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;



public class w1_1486_이종환 {
	
	static int goal = -1;
	static int min = 10000000;
	static int cnt = 0;
	static int calcCnt = 0;
	
	public static void dfs(int curSum, int curIdx, int[] people, boolean[] visited) {
		calcCnt++;
		if (curSum >= goal) {
			min = Math.min(curSum-goal, min);
			return;
		} else {
			for (int i = curIdx; i < cnt; i++) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(curSum + people[i], i + 1, people, visited);
					visited[i] = false;
					
				}
			}
			
		}
		
		
	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			
			min = 10000000;
			
			cnt = sc.nextInt();
			goal = sc.nextInt();
			
			int[] people = new int[cnt];
			boolean[] visited = new boolean[cnt];
			
			for (int i = 0; i < cnt; i++) {
				int input = sc.nextInt();
				people[i] = input;
			}
			
			Arrays.sort(people);
			dfs(0,0,people,visited);
			
			System.out.println("#" + test_case +" " + min );
			
			
		}
	}
} 