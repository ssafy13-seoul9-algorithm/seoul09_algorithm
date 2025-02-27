import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// < : idx를 줄일 수 있다면 줄인다.
		// > : idx를 늘릴 수 있다면 늘린다.
		// - : idx 이전의 문자를 삭제하고, idx를 줄이고 생성된 문자열의 길이 totIdx를 줄인다.
		//   : idx 이전의 문자가 존재하지 않는다면 처리되지 않도록 한다.
		// 알파벳, 숫자 : 알파벳이나 숫자를 추가하고, idx를 늘리고 생성된 문자열의 길이 totIdx를 늘린다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for(int tc =0; tc<testCase; tc++){
			String str = br.readLine();
			int len = str.length();

			LinkedList<Character> list = new LinkedList<>();

			int idx = 0;
			int totIdx = 0;
			for(int i=0; i < len ; i++){
				if(str.charAt(i)=='<'){
					if(idx == 0){
						continue;
					}else{
						idx--;
					}
				}
				else if(str.charAt(i)=='>'){
					if(idx == totIdx){
						continue;
					}else{
						idx++;
					}

				}else if(str.charAt(i)=='-'){
					if(idx != 0){
						list.remove(idx-1);
						idx--;
						totIdx--;
					}

				}else{
					list.add(idx, str.charAt(i));
					//System.out.printf("%d %s\n", idx, str.charAt(i));
					idx++;
					totIdx++;
				}

				//System.out.println(list);

			}

			StringBuilder sb = new StringBuilder();
			for(char c: list){
				sb.append(c);
			}
			System.out.println(sb);

			//System.out.println(list);

		}






	}
}
