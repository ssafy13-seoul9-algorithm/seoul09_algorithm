import java.util.*;
import java.io.*;

public class Main {
	// L   커서를 왼쪽으로 옮길 수 있다면, 한칸 옮긴다.
	// D   커서를 오른쪽으로 옮길 수 있다면, 한칸 옮긴다.
	// B   커서 왼쪽에 있는 문자를 삭제할 수 있다면, 삭제한다.
	// P $ $라는 문자를 커서 왼쪽에 추가한다.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 기존 문자열을 저장한다.
		String orgStr = br.readLine();
		LinkedList<Character> list = new LinkedList<>();
		int len = orgStr.length();

		for(int i=0; i<len ; i++){
			list.add(orgStr.charAt(i));
		}

		// Linked List의 참조값(주소)를 저장하기 위한, List Iterator를 만든다.
		ListIterator<Character> it = list.listIterator(len);

		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++){
			String ordStr = br.readLine();

			char[] charOrd = ordStr.toCharArray();
			char cmd = charOrd[0];

			if(cmd == 'P' ){
				char ch = charOrd[2];
				it.add(ch);

			}
			else if(cmd == 'L'){
				if(it.hasPrevious()){
					it.previous();
				}
			}
			else if(cmd == 'D'){
				if(it.hasNext()){
					it.next();
				}

			}
			else if(cmd == 'B'){
				if(it.hasPrevious()){
					it.previous();
					it.remove();
				}
			}


		}

		StringBuilder sb = new StringBuilder();
		for(char c: list){
			sb.append(c);
		}

		System.out.println(sb);




	}

}
