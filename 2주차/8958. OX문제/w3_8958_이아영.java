import java.util.*;

// 소문자/대문자로만 이루어진 길이가 n인 단어
// 한 줄에 10글자씩 끊어서 출력
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			String s = sc.next();
			// 연속으로 맞은 경우 1 추가, X 나오면 0으로 리셋
//			0번부터 N번까지 O인지 X인지 확인
//			O면 1점 주기, X면 0점으로 리셋
//			연속적으로 O면 1점씩 누적
			int len = s.length();
			int bonus = 0;
			int score = 0;
			for (int j = 0; j < len; j++) {
				char q = s.charAt(j);
				if (q == 'O') {
					bonus++;
				} else if (q == 'X') {
					bonus = 0;
				}
				score += bonus;
				
			}
			System.out.println(score);
			
		}
		sc.close();
		
	}
}