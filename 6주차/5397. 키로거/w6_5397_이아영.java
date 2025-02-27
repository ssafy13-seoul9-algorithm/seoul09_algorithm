import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        sc.nextLine(); // 줄바꿈을 소비
        for (int tc = 0; tc < T; tc++) {
            
            String str = sc.nextLine();  // 입력 받기
            // 비밀번호를 저장할 리스트
            LinkedList<Character> list = new LinkedList<>();
            // 양방향 iterator - 입력순서니까 커서는 처음부터
            ListIterator<Character> iter = list.listIterator(); 
            
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                // list에서는 가져오기만 하고 iter 통해서만 수정
               
                if (ch == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();  // 커서를 뒤로 한 칸 이동
                        iter.remove();    // 현재 커서 위치에서 문자 삭제
                    }
                } else if (ch == '<') {
                    if (iter.hasPrevious()) {
                        iter.previous();  // 커서를 왼쪽으로 이동
                    }
                } else if (ch == '>') {
                    if (iter.hasNext()) {
                        iter.next();  // 커서를 오른쪽으로 이동
                    }
                } else {
                    iter.add(ch);  // 문자 입력
                }
            }
            
            // StringBuilder로 결과를 출력
            StringBuilder sb = new StringBuilder();
            for (Character c : list) {
                sb.append(c);
            }
            
            System.out.println(sb.toString());  // 결과 출력
        }
        
        sc.close();
    }
}
