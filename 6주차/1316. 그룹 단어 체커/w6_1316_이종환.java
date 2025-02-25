import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class w6_1316_이종환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for (int i = 0; i < tc; i++) {
			String[] input = br.readLine().split("");
			Set<String> chars = new HashSet<String>();
			
			boolean isContinuous = true;
			
			for (int j = 0; j < input.length;j++) {
				if (chars.contains(input[j])) {
					isContinuous = false;
					break;
				} else {
					// 없다면 넣어주고 같은 단어가 나오는 곳까지 쭉 진행
					chars.add(input[j]);
					String target = input[j];
					
					while(j != input.length-1 && input[j+1].equals(target)) {
						j++;
					}
				}
			}
			
			if (isContinuous) cnt++;
		}
		
		System.out.println(cnt);
	}
}