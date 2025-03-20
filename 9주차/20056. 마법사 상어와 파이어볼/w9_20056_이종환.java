import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static HashSet<Fire> fires = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int size = Integer.parseInt(st.nextToken());
		int fireCnt = Integer.parseInt(st.nextToken());
		int totalMove = Integer.parseInt(st.nextToken());
		
		
		for (int i = 0; i < fireCnt; i++) {
			
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			
			int weight = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			
			fires.add(new Fire(y,x,weight,speed,direction));
		}
		
		for (int time = 1; time <= totalMove; time++) {
			Fire[][] visited =new Fire[size][size];
			Fire[] fireArr = fires.toArray(new Fire[fires.size()]);
			// set을 순회돌리면서 중간에 변경하면 안되기에 arr화
			for (int i = 0; i < fireArr.length; i++) {
				Fire fire = fireArr[i];
				int nY = (fire.y + dy[fire.direction])%size;
				int nX = (fire.x + dx[fire.direction])%size;
				
				fire.y = nY;
				fire.x = nX;
				
				if (nY <0 || nX <0 || nY >= size || nX >=size) {
					fires.remove(fire);
					continue;
				}
				
				if (visited[nY][nX] != null) visited[nY][nX].combine(fire);
				else visited[nY][nX] = fire;
			}
			fireArr =  fires.toArray(new Fire[fires.size()]);
			
			for (int i = 0; i < fireArr.length; i++) {
				Fire fire = fireArr[i];
				if (fire.cnt > 1) fire.split();
			}
		}
		
		int ans =0;
		for (Fire fire: fires) ans += fire.weight;
		System.out.println(ans);
		
	}
	
	static class Fire{
		int y;
		int x;
		int weight;
		int speed;
		int direction;
		int cnt = 1; // 담긴 파이어볼 개수
		boolean isSame = true; // 합쳐진 파이어볼의 방향이 다 짝/홀인지 저장
		
		public Fire(int y, int x , int weight, int speed, int direction) {
			super();
			this.weight = weight;
			this.speed = speed;
			this.direction = direction;
		}
		
		public void combine(Fire t) {
			this.weight += t.weight;
			this.speed += t.speed;
			
			if ((t.direction + this.direction)%2 == 1) isSame = false;
			 // 합쳐진 불 기록
			fires.remove(t);
			
			cnt++;
		}
		
		public void split() {
			int nWeight = this.weight/5;
			int nSpeed = this.speed/this.cnt;
			int nDirection = (isSame)?-2:-1;
			
			fires.remove(this);
			if (nWeight == 0) {
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				fires.add(new Fire(this.y, this.x, nWeight, nSpeed, nDirection+=2));
			}
			
			
		}
		
		
		
	}
}
