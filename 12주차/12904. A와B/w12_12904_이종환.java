import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class w12_12904_이종환 {
	//완성부터 다가가자.
	// 결국 뒤에 더하는거 밖에 못한다.
	// 맨뒤가 a이면 제거. B이면 제거 후 뒤집기. 이를 반복한다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String from = br.readLine();
		char[] to = br.readLine().toCharArray();
		int goal = from.length();
		
		for (int i = to.length-1; i >= goal; i--) {
			if (to[i] == 'A') continue;
			char[] temp = new char[i];
			for (int j = 0; j < i; j++) temp[j] = to[i-1-j];
			to = temp;
		}
		String result = String.copyValueOf(to).substring(0,goal);
		System.out.println(result.equals(from)?1:0);

	}
}
