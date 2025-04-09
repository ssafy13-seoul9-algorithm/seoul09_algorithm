import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class w12_1946_이종환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			// 서류성적 순으로 오름차순 후,여태까지 검사 한 대상의 면접시험 성적중 최고 성적을 넘는지를 확인
			// 인데 굳이 정렬을 할 필요가? 그냥 처음부터 순서대로 넣자.
			int peopleCnt = Integer.parseInt(br.readLine());
			int[] arr = new int[peopleCnt+1];
			for (int i = 0; i < peopleCnt; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int j = Integer.parseInt(st.nextToken());
				int k  = Integer.parseInt(st.nextToken());
				arr[j] = k;
			}
			int ans = 1;
			int highestRank = arr[1];
			for (int i = 2; i<= peopleCnt; i++) {
				if(arr[i] > highestRank) continue;
				
				highestRank = arr[i];
				ans++;
			}
			System.out.println(ans);
			
		}
		
		
	}
}
