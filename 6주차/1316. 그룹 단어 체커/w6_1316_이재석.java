import java.util.*;

public class BJ1316 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());

        int cnt = 0;
        for(int tc = 1; tc <= testCase; tc++){
            String str = sc.nextLine();
            char[]  strCharArray = str.toCharArray();
            int len = strCharArray.length;

            HashMap<Character, Integer> m = new HashMap<Character, Integer>();
            boolean isGroup = true;
            m.put(strCharArray[0], 0);
            for(int i=1; i<len; i++){

                // HashMap안에 해당되는 키가 있는데, idx가 연속적으로 나타나지 않는다면 false 처리한다.
                int idx = -1;
                if(m.containsKey(strCharArray[i])){
                    idx = m.get(strCharArray[i]);
                    if(idx != i-1){
                        isGroup = false;
                    }
                }
                // HashMap 내 특정 키의 가장 최근 idx를 업데이트 한다.
                m.put(strCharArray[i], i);
                //System.out.println(isGroup);
            }

            if (isGroup)
                cnt++;

            //System.out.println(cnt);
            //System.out.println(isGroup);

            //System.out.println(m);



            // h, a, p, p, y, a
            // 0, 1, 2, 3, 4, x

        }

        System.out.println(cnt);

    }

//    Set<Character> s = new HashSet<>();
//    for(int i=0; i< len; i++){
//        // 첫번째 글자 이후, set안에 이미 단어가 들어 있는데 이전 단어가 아니면 true 이다.
//        if(i !=0 && (s.contains(strCharArray[i]) && temp == i-1) ){
//            isGroup = true;
//            temp = i;
//        }
//        System.out.println(temp);
//        s.add(strCharArray[i]);
//
//
//    }

}
