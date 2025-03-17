import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class w9_22858_이종환 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cardNum = Integer.parseInt(st.nextToken());
		int shuffleCnt = Integer.parseInt(st.nextToken());
		
		int[] result = new int[cardNum];
		int[] ans = new int[cardNum];
		
		st = new StringTokenizer(br.readLine());
		
		int[] shuffle = new int[cardNum];
		for (int i = 0; i < cardNum; i++) result[i] = Integer.parseInt(st.nextToken()) ;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < cardNum; i++) shuffle[i] = Integer.parseInt(st.nextToken())-1;
		
		for (int i = 0; i < cardNum; i++) {
			int target = result[i];
			int repeatCnt = 0;
			int cur = i;
			
			do {
				repeatCnt++;
				cur = shuffle[cur];
			} while(cur != i);
			
			int shortRepeat = shuffleCnt%repeatCnt;
			
			for (int j = 0; j< shortRepeat; j++) cur = shuffle[cur];
			
			ans[cur] = target;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ans.length; i++) sb.append(ans[i]).append(" ");;
		
		System.out.println(sb.toString());
		
	}
}

//4 3 1 2 5
//
//3 : 4 -> 1
//3: 1 -> 3
//3: 3 ->2
//3: 2 -> 4
//Di => Di번째카드를 i번째로 !
// 반대로라면 i번째 있는 것을 Di번째로!