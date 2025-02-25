import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class w6_12789_이종환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int studentCnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Queue<Integer> students = new LinkedList<Integer>();
		for (int i = 1; i <= studentCnt; i++) {
			students.add(Integer.parseInt(st.nextToken()));
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		int target = 1;
		while (!students.isEmpty()) {
			
			if (target == students.peek()) { // 큐 앞 사람과 목표가 일치하면 바로 들어감
				students.poll();
				target++;
				continue;
			} else if (!stack.empty() && stack.peek() == target) {
				// 만약 스택에 있는 사람과 목표가 일치하면 그 사람이 들어감
				stack.pop();
				target++;
				continue;
			} else {
				// 둘다 아니면  스택에 사람을 넣음
				stack.push(students.poll());
				
			} 
		}
		
		while(!stack.empty()) {
			if (stack.pop() != target++) {
				System.out.println("Sad");
				return;
			} 
		}
		
		System.out.println("Nice");
	}
}
