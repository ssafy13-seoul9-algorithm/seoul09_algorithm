import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class w12_1715_이종환 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		int cardCnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < cardCnt; i++) pq.add(Long.parseLong(br.readLine()));
		
		long ans = 0;
		while (pq.size()!= 1) {
			// 제일 작은 두개 빼옴
			long sum = pq.poll() + pq.poll();
			ans += sum;
			pq.add(sum);
		}
		
		System.out.println(ans);
		
	}
}
