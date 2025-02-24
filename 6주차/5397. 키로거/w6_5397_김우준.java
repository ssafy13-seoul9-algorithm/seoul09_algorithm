import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위해 Scanner 대신 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            // 잦은 수정으로 빠른 연산을 위해 LinkedList사용
            List<Character> list = new LinkedList<>();
            // 탐색을 위해 Iterator 사용해서 커서로 활용
            ListIterator<Character> cursor = list.listIterator(list.size());
            // StringTokenizer st = new StringTokenizer(br.readLine(), "", true);
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
            // while (st.hasMoreTokens()) {
                // char m = st.nextToken().charAt(0);
                char m = str.charAt(j);
                if (m == '<') {
                    // 만약 현재 커서 위치에서 이전 인덱스가 있다면, 커서 위치 -1
                    if (cursor.hasPrevious())
                        cursor.previous();
                } else if (m == '-') {
                    // 만약 현재 커서 위치에서 이전 인덱스가 있다면, 커서 위치 -1 하고 해당 문자 삭제
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                } else if (m == '>') {
                    // 만약 현재 커서 위치에서 다음 인덱스가 있다면, 커서 위치 +1
                    if (cursor.hasNext())
                        cursor.next();
                } else {
                    // 현재 커서 위치에 문자 삽입
                    cursor.add(m);
                }
            }
            for(char c:list)sb.append(c);
            sb.append('\n');
        }
        // 연결리스트 문자열 변환
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
