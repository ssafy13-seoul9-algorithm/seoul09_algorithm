import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class w6_2504_이종환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] opens = {"(","["};
		String[] closes = {")","]"};
		
		String[] input = br.readLine().split("");
		
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < input.length; i++) {
			String t =input[i];
			if (t.equals(opens[0]) || t.equals(opens[1])) {
				// 여는거면 일단 스택에 넣음
				stack.push(t);
			} else {
				// 아니면 닫는거니까
				String goal = "";
				for (int j = 0; j <2; j++) {
					if (t.equals(closes[j])) goal = opens[j];
				}
				
				int result = 0;
				
				
				loop:
				while(true) {
					if (stack.isEmpty()) {
						System.out.println(0);
						return;
					}
					String target = stack.pop();
					for (int j = 0; j < 2; j++) {
						if(target.equals(opens[j])){
							if (target.equals(goal)) {
								result  = (result ==0)? j+2: result *(j+2);
								
								stack.add(Integer.toString(result));
								break loop;
							} else {
								// 숫자도 아니고, 그렇다고 원하는 닫힘이 아닌경우
								// ex. 목표가 ( 인데 [가 나옴.
								System.out.println(0);
								return;
							}
						}
					}

					
					//여기까지 왔으면 숫자임
					
					result += Integer.parseInt(target);
				}	
			}
		}
		
		int ans = 0;
		
		while(!stack.isEmpty()) {
			
			String target = stack.pop();
			
			for (int i = 0; i < 2; i++) {
				if ( target.equals(opens[i]) ||target.equals(closes[i])) {
					System.out.println(0);
					return;
				}
			}
			
			//여기까지 왔으면 숫자임
			
			ans += Integer.parseInt(target);
			
		}
		
		System.out.println(ans);
		


	}
}


