
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        List<Character> linkedList = new LinkedList<>();
        for(int i=0; i<word.length(); i++){
            linkedList.add(word.charAt(i));
        }

        int num = Integer.parseInt(br.readLine());
        
        // ListIterator<Character> listIterator = arrayList.listIterator(); -> 처음에 이렇게 썼었음
        // 커서를 맨 끝으로 이동시키기 위해 listIterator(size) 사용
        ListIterator<Character> listIterator = linkedList.listIterator(linkedList.size());

        for(int i=0; i<num; i++){
            String editor = br.readLine();
            if(editor.charAt(0) == 'P'){
                char charac = editor.charAt(2);
                listIterator.add(charac);
            }

            if(editor.equals("L")){
                // 리스트 범위 안 넘어가면
                if(listIterator.hasPrevious()) listIterator.previous();
            }else if(editor.equals("D")){
                // 리스트 범위 < 0
                if(listIterator.hasNext()) listIterator.next();
                
            }else if(editor.equals("B")){
                if(!listIterator.hasPrevious()) continue;
                else{
                    listIterator.previous();
                    listIterator.remove();
                }
            }

        }

        for (char ch : linkedList) {
            bw.write(ch);
        }

        bw.flush();
        bw.close();
        br.close();

    }
}