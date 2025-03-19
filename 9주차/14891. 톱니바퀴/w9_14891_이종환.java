import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class w9_14891_이종환 {
	static ArrayList<Deque<Integer>> gears;
	static BufferedReader br;
	static int totalTurn;
	static int[] turnDirections;
	
	public static void main(String[] args) throws IOException {
		init();
		processTurnings();
		
		System.out.println(calculateAnswer());
	}
	
	private static int calculateAnswer() {
		int ans = 0;
		for (int i = 0; i < 4 ; i++) {
			for (int j = 0; j < 2; j++) gears.get(2*i+1).pollFirst();
			ans += gears.get(2*i+1).getFirst()<<i;
		}
		return ans;
		
	}

	private static void init() throws IOException  {
		// 톱니바퀴 한개를 아래부분, 윗부분으로 나눠서 보관
		br = new BufferedReader(new InputStreamReader(System.in));
		gears = new ArrayList<>();

		for(int i = 0; i < 8; i++) gears.add(new LinkedList<>());
		for(int i = 0; i < 4; i++) {
			int[] rawInput =Arrays.stream((br.readLine().split(""))).mapToInt(Integer::parseInt).toArray();
			
			// 0~1 : 첫번째의 아랫부분/윗부분... 이 순서
			// 가장 왼쪽 톱니가 아랫부분의 첫번째, 가장 오른쪽 톱니가 윗부분의 첫원소로
			gears.get(i*2+1).add(rawInput[7]);
			for (int j = 0; j < 3; j++) {
				gears.get(i*2+1).addFirst(rawInput[j]);
			}
			for (int j = 3; j < 7; j++) gears.get(i*2).addFirst(rawInput[j]);
			
			
		}
	}
	
	private static void processTurnings() throws NumberFormatException, IOException {
		totalTurn = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < totalTurn; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken())-1;
			int turnDirection = Integer.parseInt(st.nextToken());
			processTurning(target,turnDirection);
		}
	}
	
	private static void processTurning(int target, int turnDirection) {
		// turnDirections의  값이 0이면 처음, -1이면 왼쪽의 톱니바퀴에 의해 , 1이면 오른쪽 톱니바퀴에 의해 돌아가는것.
		turnDirections = new int[4];
		turnDirections[target] = turnDirection;
		addTarget(target, turnDirection);
		
		for (int i = 0; i < 4; i++) {
			if (turnDirections[i] == 0) continue;
			
			Deque<Integer> downSide = gears.get(2*i);
			Deque<Integer> upSide = gears.get(2*i+1);
			if (turnDirections[i] == 1) {
				upSide.addLast(downSide.pollFirst());      
				downSide.addLast(upSide.pollFirst());
			} else {
				upSide.addFirst(downSide.pollLast());
				downSide.addFirst(upSide.pollLast());
			}
		}
		
	}
	
	private static void addTarget(int target, int turnDirection) {
		if (target!= 3 && turnDirections[target+1] == 0) {
			if (gears.get(2*target+1).getFirst() != gears.get(2*target+2).getFirst()) {
				turnDirections[target+1] = turnDirection*(-1) ;
				addTarget(target+1,turnDirection*(-1));
			}
		} 
		
		if (target!= 0 && turnDirections[target-1] == 0) {
			if (gears.get(2*target).getFirst() != gears.get(2*target-1).getFirst()) {
				turnDirections[target-1] = turnDirection*(-1);
				addTarget(target-1,turnDirection*(-1));
			}
		}
	}
	
}
