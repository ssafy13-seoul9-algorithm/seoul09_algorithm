import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class w7_7569_이종환 {
	
	//순서대로 위층,아래층,상,하,좌,우
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dx = {0,0,0,0,-1,1};
	static int[] dz = {1,-1,0,0,0,0};
	static int width;
	static int height;
	static int depth;
	static int left = 0;
	static int day = 0;
	
	static int[][][] tomatos;
	static boolean[][][] visited;
	static Queue<Coordination> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		depth = Integer.parseInt(st.nextToken());
		
		tomatos = new int[depth][height][width];
		visited = new boolean[depth][height][width];
		
		
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j < height; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k <width ; k++) {
					tomatos[i][j][k] = Integer.parseInt(st.nextToken());
					
					//익은 토마토거나, 비어있는 곳은 visited 처리
					if (tomatos[i][j][k] != 0) {
						visited[i][j][k] = true;
						if (tomatos[i][j][k] == 1) {
							q.add(new Coordination(i,j,k));
						}
					} else {
						left++; //남은 토마토
					}
					
				}
			}
		}
		
		bfs();

		System.out.println((left == 0)?day:-1);

	}
	
	private static void bfs() {
		while (left!= 0 && !q.isEmpty()) {
			day++;
			int qSize = q.size();
			
			for (int i = 0; i < qSize; i++) {
				Coordination tomato = q.poll();
				
				int z = tomato.depth;
				int y = tomato.y;
				int x = tomato.x;
				for (int j = 0; j < 6; j++) {
					
					int tZ = z + dz[j];
					int tY = y + dy[j];
					int tX = x + dx[j];
					
					if(!isValid(tZ,tY,tX)) continue;
					
					left--;
					visited[tZ][tY][tX] = true;
					q.add(new Coordination(tZ,tY,tX));
					
				}
				
			}
		}
	}
	
	
	private static boolean isValid(int z, int y, int x) {
		if (z < 0 || y < 0 || x < 0 ||
				z >= depth || y >= height || x >= width || visited[z][y][x]) {
			return false;
		}
		
		return true;
	}
	
	
	static class Coordination{
		int depth;
		int y;
		int x;
		
		public Coordination(int depth, int y, int x) {
			super();
			this.depth = depth;
			this.y = y;
			this.x = x;
		}
		
	}

	
}
