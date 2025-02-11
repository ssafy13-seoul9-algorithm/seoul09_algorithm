import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ10815_Set {
    public static void main(String[] args) throws IOException {
        Set<Integer> set = new HashSet<>();
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 상근이가 갖고 있는 cardNum을 set으로 만들어준다.
        // set은 왜 접근하는 데 O(1)일까?
        int cardNum = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<cardNum; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        // 주어진 set에 접근하여, totCardList에 해당 숫자가 있는지 확인한다.
        // 이진탐색을 이용해서 탐색을 할 경우, 정렬 + 이진탐색을 해야 하는 경우 시간복잡도가 크게 늘어날 수 있기 때문에,
        // 그냥 그러느니 찾고자하는 데이터를 Set으로 구성해서 접근하는 것이 더 좋은 방법일 수 있다.
        int totCardNum =  Integer.parseInt(br.readLine());
        int[] totCardList = new int[totCardNum];

        int[] result = new int[totCardNum];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<totCardNum; i++){

            totCardList[i] =Integer.parseInt(st.nextToken());
            int exist = set.contains(totCardList[i])? 1: 0;

            //result[i] = exist;
            System.out.print(exist+ " ");
        }

//        for(int i=0; i<totCardNum; i++){
//            if(i!=totCardNum-1)
//                System.out.printf("%d ", result[i]);
//            else
//                System.out.printf("%d", result[i]);
//        }







    }
}
