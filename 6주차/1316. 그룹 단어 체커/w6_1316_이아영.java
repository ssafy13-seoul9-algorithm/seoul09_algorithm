import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		// 각 문자 연속해서 나타남 /
		Scanner sc = new Scanner(System.in);
			
		int N = sc.nextInt(); 
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next(); 
			char[] cArr = new char[str.length()];
			
			for (int c = 0; c < str.length(); c++) {
				cArr[c] = str.charAt(c);
			}
			
			// 등장했던 단어 집합
			Set<Character> words = new HashSet<>();
			boolean isGroupWord = true; // 단어 판별
			
			// 단어가 1자리이면 무조건 그룹단어 > 조건 1번만 체크 
			if (str.length() == 1) isGroupWord = true;
			
			// 단어가 2자리 이상일 때 체크 
			// 현재 값 기준으로 다음 값과 체크
			for (int c = 0; c < cArr.length - 1; c++) {
				// 처음 등장한 단어를 단어집합에 저장
				words.add(cArr[c]);
				// 현재 단어 == 다음 단어 -> 넘어가기 / 그룹단어 ok
				if (cArr[c] == cArr[c+1]) {
					continue;
					// 현재 단어 != 다음 단어
				} else {
					// 다음단어가 기존에 등장했던 문자면 > 그룹단어 ㄴㄴ
					if(words.contains(cArr[c+1])) {
						isGroupWord = false;
						// 다음단어가 등장하지 않았던 문자면 괜찮아 그룹단어 ㅇㅋ?
					} else {
						continue;
					}
				}
			// 단어들이 연속해서 나오지 않으면 그룹단어 X
			// 기존에 등장했던 문자가 또 등장하면 X
			}
			
			if (isGroupWord) cnt++;
		} // 그룹 단어 체크
		System.out.println(cnt);
		// 기존에 나왔던 단어 집합 
		// 연속해서 나오지 않으면 그룹단어 아님 
		
		// 연속되지 않은 문자 > 이전 문자와 비교
		// 현재 문자가 다른 문자인지 확인
		// 문자가 다르면 그 문자 앞에 다른 문자가 등장했는지 체크하기
	
		
		sc.close();
	}
}
