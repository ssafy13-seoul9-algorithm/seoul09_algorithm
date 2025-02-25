import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next(); // 초기 편집기 문자열

		// arraylist 시간초과 뜸 -> linkedlist로 가자
		LinkedList<Character> clist = new LinkedList<Character>();
        //		ArrayList<Character> cArr = new ArrayList<Character>();
		// 기본 문자 추가
		for (int i = 0; i < str.length(); i++) {
			clist.add(str.charAt(i));
		}
		
		int N = clist.size(); // 문자열 길이
		int M = sc.nextInt(); // 입력할 명령어 개수
		ListIterator<Character> iter = clist.listIterator(N);
		// 가장 끝으로 커서 설정

		for (int i = 0; i < M; i++) {
			char cmd = sc.next().charAt(0);
			// 커서는 기본적으로 가장 끝에 있다고 가정
			switch(cmd) {
			case 'P': // 다음에 오는 문자를 커서 왼쪽에 추가
				char c = sc.next().charAt(0);
				iter.add(c);
				// 추가 후 오른쪽으로 커서 이동
				break;
			case 'L': // 커서를 왼쪽으로 한 칸 이동
				// 커서가 문장의 맨 앞이면 무시
				if (iter.hasPrevious()) iter.previous();
				// 이전 값이 있으면 이전으로 이동 
				break;
			case 'D': // 커서를 오른쪽으로 한 칸 이동
				if (iter.hasNext()) iter.next();
				break;
			case 'B': //커서 왼쪽의 문자 삭제 
				if (iter.hasPrevious()) { // 이전 값이 있으면
					iter.previous(); // 커서 왼쪽으로 이동
					iter.remove();// 현재 커서 위치 문자 삭제
				}
				break;
			} // switch
			
		} // 명령어 입력
		StringBuilder sb = new StringBuilder();
		for (char ch : clist) {
			sb.append(ch);
		}
		System.out.println(sb);
		
		sc.close();
	}
}
