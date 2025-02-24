import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위해 Scanner 대신 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        // 잦은 수정으로 빠른 연산을 위해 LinkedList사용
        List<Character> list = new LinkedList<>();
        for(char c : str.toCharArray()){
            list.add(c);
        }

        // 탐색을 위해 Iterator 사용해서 커서로 활용
        ListIterator<Character> cursor = list.listIterator(list.size());
        
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char m = st.nextToken().charAt(0);
            if(m == 'P') {
                char c = st.nextToken().charAt(0);
                // 현재 커서 위치에 문자 삽입
                cursor.add(c);
            } else if (m == 'L') {
                // 만약 현재 커서 위치에서 이전 인덱스가 있다면, 커서 위치 -1
                if(cursor.hasPrevious()) cursor.previous();
            } else if (m == 'B'){
                // 만약 현재 커서 위치에서 이전 인덱스가 있다면, 커서 위치 -1 하고 해당 문자 삭제
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            } else if (m == 'D'){
                // 만약 현재 커서 위치에서 다음 인덱스가 있다면, 커서 위치 +1
                if(cursor.hasNext()) cursor.next();
            }
        }

        StringBuilder sb = new StringBuilder();
        // 연결리스트 문자열 변환
        for(char c : list) sb.append(c);
        System.out.println(sb.toString());
    }
}