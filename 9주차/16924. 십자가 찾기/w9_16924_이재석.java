import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class w9_16924_이종환 {
	
	static int leftStar, crossCnt, height,width = 0;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static String[][] arr;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		init();
		process();
		print();
	}
	
	
	private static void init() throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));;
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		arr = new String[height][width];
		visited = new boolean[height][width];
		
		for (int i = 0; i < height; i++) {
			arr[i] = br.readLine().split("");
			for (int j = 0; j < width; j++) {
				if (arr[i][j].equals("*")) leftStar++;
			}
		}
	}
	
	
	private static void print() {
		if (leftStar != 0) {
			System.out.println("-1");
		} else {
			System.out.println(crossCnt);
			System.out.println(sb.toString());
		}
	}
	
	
	private static void process() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (leftStar == 0) break;
				if (arr[i][j].equals(".")) continue;
				
				drawCross(getCrossSize(i,j),i,j);
			}
		}
	}
	
	
	private static int getCrossSize(int y, int x) {
		int size = Integer.MAX_VALUE;
		
		for (int k = 0; k < 4; k++) {
			int curSize = 1;
			
			while(true) {
				int tY = y + dy[k]*curSize;
				int tX = x + dx[k]*curSize;
				
				if (check(tY,tX)) break;
				curSize++;
			}
			size = Math.min(size, --curSize);
		}
		return size;
	}
	
	
	private static boolean check(int tY,int tX) {
		if (tY < 0|| tX <0 || tY >= height || tX >= width || arr[tY][tX].equals(".")) return true;
		return false;
	}

	
	private static void drawCross(int size,int y, int x) {
		if (size == 0) return;
		
		if (!visited[y][x]) leftStar--;
		visited[y][x] = true;
		crossCnt++;
		sb.append(y+1).append(" ").append(x+1).append(" ").append(size).append("\n");
		
		for (int k = 1; k <= size; k++) {
			for (int l = 0; l < 4; l++) {
				int tY = y + dy[l]*k;
				int tX = x + dx[l]*k;
				
				if (!visited[tY][tX]) leftStar--;
				visited[tY][tX] = true;
			}
		}
	}
	
	
}
