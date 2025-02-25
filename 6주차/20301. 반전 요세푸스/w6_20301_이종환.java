import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class w6_20301_이종환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int peopleCnt = Integer.parseInt(st.nextToken());
		int interval = Integer.parseInt(st.nextToken());
		int oppositeNum = Integer.parseInt(st.nextToken());
		int removalCnt = 0;
		
		boolean isOpposite = false;
		
		List<Integer> people = new LinkedList<Integer>();
		for (int i = 1; i <= peopleCnt; i++) {
			people.add(i);
		}
		
		int target = 0;
		
		while(!people.isEmpty()) {
			if(!isOpposite) {
				// 정방향 순회
				target += interval-1;
				target %= people.size();
				
				System.out.println(people.remove(target));
			} else {
				// 역방향 순회시 벗어나지 않기위해 리스트 사이즈로 나뉘어지는 큰 값.
				target += (people.size()*5000) - (interval);
				target %= people.size();
				
				System.out.println(people.remove(target));
			}
			
			removalCnt++;
			if (removalCnt == oppositeNum) {
				removalCnt = 0;
				isOpposite = isOpposite?false: true; // 반대로 변경
			}
		}
	}
}