import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 앞에 서있는 학생 수
		int N = sc.nextInt();
		// 번호표 순서대로 > 여기는 큐구나 
		Queue<Integer> nums = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			nums.offer(sc.nextInt()); 
		}
		// 1-N 순서대로 들어갈 수 있으면 ok
		boolean isOk = true;
		int[] goal = new int[N];
		
		// 맨 앞 1열 공간
		Stack<Integer> tmp = new Stack<Integer>();
		
		// 대기열 > 간식 받기 or 스택에 들어가기 택1
		int num = 1; // 번호표 순서대로
//		int item = -1; 
		int idx = 0;
		
		// 스택/큐 2개 peek에서 1 - N 순서대로 들어가면 ok
        while (!nums.isEmpty() || !tmp.isEmpty()) {

            // 큐의 맨 앞 숫자 / 순번 일치 확인 
            if (!nums.isEmpty() && nums.peek() == num) {
                goal[idx++] = nums.poll(); // 간식 받음
                num++; 
            } 
            // 스택의 맨 위 숫자 / 순번일치 확인 
            else if (!tmp.isEmpty() && tmp.peek() == num) {
                goal[idx++] = tmp.pop(); // 간식 받음
                num++;
            } 
            // peek 불일치 > 스택으로 이동
            else {
                if (!nums.isEmpty()) {
                    tmp.push(nums.poll());
                } else {
                    break; // 더 이상 진행할 수 없음
                }
            }
        } // 제거
		
//		System.out.println(Arrays.toString(goal));
		
		// 정답 집합
        // 반복 다 돌고, stack에 값이 남아있으면 false
		for (int i = 0; i < N; i++) {
			if (goal[i] != (i+1)) {
				isOk = false;
				break;
			}
		}
		
		

		String res = isOk? "Nice" : "Sad";
		System.out.println(res);
		sc.close();

	}
}
