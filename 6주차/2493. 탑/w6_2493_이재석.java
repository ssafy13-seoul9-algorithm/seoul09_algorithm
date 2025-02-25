import java.util.Scanner;
import java.util.Stack;
import java.io.*;
import java.util.*;

public class BJ2493_new {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] intInput = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            intInput[i][0] = Integer.parseInt(st.nextToken());
            intInput[i][1] = i+1;
        }

        // System.out.println(Arrays.deepToString(intInput));

        Stack<int[]> s = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){

            // Stack이 비어 있지 않고, input값 보다 Stack의 빌딩 높이가 더 작은 것이 있다면 pop한다.
            // intInput 보다 작은 건물들이 stack에 있다면 모두 pop되기 때문에, 최종적으로 stack에는 큰 빌딩만 남는다.
            while( !s.isEmpty() && intInput[i][0] > s.peek()[0] ){
                s.pop();
            }

            int idx = 0;
            if(s.isEmpty())
                idx = 0;
            else
                idx = s.peek()[1];

//             System.out.printf("%d ", idx);
            sb.append(idx);
            sb.append(" ");

            // Stack에 빌딩을 추가하여 다른 빌딩과의 높이를 비교해서, 고층 빌딩만을 Stack에 남겨둔다.
            s.add(intInput[i]);

        }

        System.out.println(sb);



    }
}
