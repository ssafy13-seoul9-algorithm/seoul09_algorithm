import java.util.Scanner;

public class w3_1244_이아영 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int switchNum = sc.nextInt(); // 스위치 개수
		
		int[] switches = new int[switchNum]; //스위치 배열
		// 스위치 상태 초기
		for (int i = 0; i < switchNum; i++) {
			switches[i] = sc.nextInt();
		}

		int studentNum = sc.nextInt(); //학생수
		for (int i = 0; i < studentNum; i++) {
			int sex = sc.nextInt(); 
			// 1 남자 2 여자
			int num = sc.nextInt();
			
			// 남자: 자신의 배수만큼 돌리기 
			if (sex == 1) {
				// arr idx는 0부터
				for (int j = 0; j < switches.length; j++) {
					if ((j+1) % num == 0) {
						switches[j] = (switches[j] == 0) ? 1 : 0; 
					}
				}
			} else { // 여자:자신 수 기준 좌우댗ㅇ(제어변수 / 가장 많은 수)
				
				// 본인은 무조건 뒤집고 
				switches[num-1] = (switches[num-1] == 0) ? 1 : 0;
				
				// 좌우 확인해서, 같으면 뒤집기
				int exIdx = 1;
				// 배열 인덱스 0번 ~ length-1번까지 비교 
				while ((num-1-exIdx >= 0) && (num-1+exIdx <= switches.length-1)) {
					// 만약 좌우 같다면 뒤집고 다음거 비교 
					if (switches[num-1-exIdx] == switches[num-1+exIdx]) {
						switches[num-1-exIdx] = (switches[num-1-exIdx] == 0)? 1 : 0; 
						switches[num-1+exIdx] = (switches[num-1+exIdx] == 0)? 1 : 0; 
						exIdx++;
					} else {break;}// 좌우다르면 반복문 끝 
				}
			}

		}
		// 한줄에 20개씩 출력
		for (int i = 0; i < switchNum; i++) {
			System.out.print(switches[i] + " ");
			// 한 줄에 20개 초과하면 다음 line
			if ((i+1) % 20 == 0) {
				System.out.println();
			}
		}
		sc.close();
	}
}
