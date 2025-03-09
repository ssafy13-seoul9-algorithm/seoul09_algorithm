import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class w8_9663_이종환 {
	

	static int size;
	static int ans = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size =  Integer.parseInt(br.readLine());
		//비트마스킹으로 접근	
		//위부터 한 열씩 내려간다고 생각하면 간다. 
		//한 칸에 퀸이 오면 그 행, 그리고 행
		chess(0, 0,0,0);
		System.out.println(ans);
	}
	
	
	private static void chess(int cnt, int straight,int left, int right) {
		
		if ( cnt == size) {
			ans++;
			return;
		}
		
		int target = (straight|left|right);
		
		
		for (int i = 0; i < size; i++) {
			// cnt 열의 i번째 칸이 가능한지 확인해야함.
			int temp = (target | (1<<i));
			if (target == temp) continue;; // 안되는 자리
			//체스 대각선을 표현하는 right와 left를 한 칸 내려갈때마다 비트연산으로 밀어주는 원리
			chess(cnt+1, straight|(1<<i), (left|(1<<i))>>1, (right|(1<<i))<<1 );
			
		}
		
		
	}
}
