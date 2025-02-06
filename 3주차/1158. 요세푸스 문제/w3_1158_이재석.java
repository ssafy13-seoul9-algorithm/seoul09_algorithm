import java.util.LinkedList;
import java.util.Queue;

import java.util.*;

public class BJ1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] stringInput = input.split(" ");
        int len = stringInput.length;
        int[] intInput = new int[len];
        for(int i=0; i<len; i++){
            intInput[i] = Integer.parseInt(stringInput[i]);
        }

//        int n = sc.nextInt();
//        int[] intArr = new int[n];
//
//        for(int i=0; i<n; i++){
//            intArr[i] = sc.nextInt();
//        }

        int pplNum = intInput[0];
        int spaceNum = intInput[1];
        // 정적 배열을 이용할 시, 죽은 사람을 빼서 배열을 관리하기 어렵기 때문에 동적 배열을 써야한다.
//        int[] josephus = new int[pplNum];
//
//        for(int i=1; i<=pplNum; i++){
//            josephus[i-1] = i;
//        }
//
//        int idx = (spaceNum-1);
//
//        while(josephus[idx]!=0){
//            System.out.println(idx+1);
//            System.out.println(josephus[idx]);
//            josephus[idx]=0;
//            pplNum -=1 ;
//            idx= (-1+idx+spaceNum) % pplNum;
//        }
//
//
//        System.out.println(Arrays.toString(josephus));

        // 요세푸스 순열을 관리하기 위한 배열을 만든다.
        // 동적 배열을 이용해야, 한명씩 죽어나갈 때 해당 사람을 뺄 수 있다.
        List<Integer> josephus = new ArrayList<>();

        for(int i=1; i<=pplNum; i++){
            josephus.add(i);
        }

        int idx = (spaceNum-1);

        System.out.printf("<");
        while(!josephus.isEmpty()){
            // 마지막 원소에 도달할 때 출력문을 다르게 구성하기 위한 조건문을 구성한다.
            if(josephus.size()!=1){
                System.out.printf("%d, ",josephus.get(idx));
            }else{
                System.out.printf("%d",josephus.get(idx));
            }
            josephus.remove(idx);
            pplNum -=1;
            // System.out.println(pplNum);
            // 마지막에 josephus 순열이 비어 있지 않는데도, idx를 업데이트하는 것을 방지하기 위한 코드
            if(pplNum != 0){
                idx = (-1 + idx + spaceNum) % pplNum;
            }
        }
        System.out.printf(">");

//        System.out.println(josephus);





        // Queue는 LinkedList를 이용해서 구현한다.
//        Queue<Integer> q = new LinkedList<>();

//        for(int i=1; i<=pplNum; i++){
//            q.add(i);
//        }
//
//        for(int i=0 ; i< pplNum; i++){
//            q.remove();
//
//        }
//
//
//        System.out.println(q);


    }
}
