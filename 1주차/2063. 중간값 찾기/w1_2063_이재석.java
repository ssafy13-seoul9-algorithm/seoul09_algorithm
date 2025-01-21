import java.util.Scanner;
import java.util.ArrayList;

public class SWEA2063 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        if(num % 2 ==0){
            System.out.println("문제 오류");
        }

        ArrayList<Integer> numList = new ArrayList<>();
        String input = sc.nextLine();
        for (String elem: input.split(" ")){
            numList.add(Integer.parseInt(elem));
        }
//        for (int i =0 ; i < num; i++){
//            int elem = sc.nextInt();
//            numList.add(elem);
//        }


        for (int i=0; i<num; i++){
            for (int j=0; j<num - 1 - i; j++){
                if(numList.get(j)> numList.get(j+1)){
                    int temp = numList.get(j);
                    numList.set(j, numList.get(j+1) );
                    numList.set(j+1, temp);
                }
            }
        }

        int idx = num/2;
        int result = numList.get(idx);
        System.out.println(result);

//        System.out.println("문장 전체를 다 입력 받아볼게!");
//        String sentence = sc.nextLine();
//        System.out.println(sentence);
//
//        System.out.println("단어 하나만 입력 받아볼게!");
//        String word = sc.next();
//        System.out.println(word);

//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(10);
//        System.out.println(list);
    }
}