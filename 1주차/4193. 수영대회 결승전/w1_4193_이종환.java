import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class w1_4193_이종환 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		int tc = sc.nextInt();
		
		for (int i = 1; i <= tc; i++) {
			int size = sc.nextInt();
			
			int[][] arr= new int[size][size];
			
			// 최단 시간 기록용 2차원 배열
			int[][] timeArr = new int[size][size];
 			
			for (int j = 0; j < size; j++) {
				for (int k= 0; k < size; k++) {
					arr[j][k] = sc.nextInt();
					timeArr[j][k] = 0;
				}
			}
			
			int startY = sc.nextInt();
			int startX = sc.nextInt();
			
			// 시작지점 표시
			timeArr[startY][startX] = -1;
			
			int endY = sc.nextInt();
			int endX = sc.nextInt();
			
			Queue<Integer> qY = new LinkedList<>();
			Queue<Integer> qX = new LinkedList<>();
			
			qY.add(startY);
			qX.add(startX);
			
			int time = 0;
			
			// 0: 빈 공간
			// 1: 고정 장애물
			// 2: 유동 장애물
			while (timeArr[endY][endX] == 0) {
				
				time++;
				
				int queSize = qY.size();
				
				if (queSize == 0) {
					time = -1;
					break;
				}
				
				
				for (int j = 0; j < queSize; j++) {
					int y = qY.remove();
					int x = qX.remove();
					boolean stay = false;
					
					for (int k = 0; k < 4; k++) {
						int targetY = y + dy[k];
						int targetX = x + dx[k];
						
						// 타겟이 인덱스 범위를 벗어났거나
						// 고정 장애물이 있는 지역이거나
						// 이미 접근한 지역인 경우 continue
						if (targetY == size || targetY == -1 || targetX == size || targetX == -1 || 
								timeArr[targetY][targetX] != 0 || arr[targetY][targetX] == 1) continue;
						
						if (arr[targetY][targetX] == 0 || ( arr[targetY][targetX] == 2 && time % 3 ==0 && time != 0) ) {
							// 빈 공간 or 잠시 장애물이 사라진 경우
							timeArr[targetY][targetX] = time;
							qY.add(targetY);
							qX.add(targetX);
							
						} else if (!stay) {
							// 유동 장애물이 켜진 경우 wait.
							// 단 한 번만 추가하는 조건을 넣는다. 
							qY.add(y);
							qX.add(x);
							stay = true;
						}		
					}
				}
				
				for (int j = 0; j < size; j++) {
					for (int k = 0; k < size; k++) {
						//System.out.print(timeArr[j][k] +" ");
					}
					//System.out.println();
				}
				//System.out.println("------");
			}
			System.out.println("#" + i + " "+ time);
		}
	}
}
