import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class w6_2493_이종환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt = Integer.parseInt(br.readLine());
		
		int[] arr =new int[cnt+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= cnt; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Stack<Pair> stack = new Stack<>();
		stack.add(new Pair(arr[1],1));
		bw.append("0 ");
		
		for (int i = 2; i <= cnt; i++) {
			int target = arr[i];
			
			while(!stack.isEmpty() && target > stack.peek().value) {
				stack.pop();
			}
			
			if (stack.isEmpty()) {
				bw.append("0 ");
			} else {
				bw.append(stack.peek().index + " ");
			}
			stack.add(new Pair(target,i));
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
}

class Pair{
	int value;
	int index;
	public Pair(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}
	
	
}