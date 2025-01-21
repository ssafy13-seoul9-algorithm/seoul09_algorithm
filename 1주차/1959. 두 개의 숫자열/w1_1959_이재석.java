import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class SWEA1959 {

    public static void main(String[] args){
        System.out.println("테스트 케이스 개수를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();

        String input1 = sc.nextLine();

        List<Integer> numList = new ArrayList<Integer>();
        for( String num : input1.split(" ")){
            numList.add(Integer.parseInt(num));
        }

        int maxSum = Integer.MIN_VALUE;
        //        int maxSum = -1000000000;

        String input2 = sc.nextLine();
        List<Integer> numListA = new ArrayList<Integer>();
        for (String num: input2.split(" ")){
            numListA.add(Integer.parseInt(num));
        }

        String input3 = sc.nextLine();
        List<Integer> numListB = new ArrayList<Integer>();
        for (String num: input3.split(" ")){
            numListB.add(Integer.parseInt(num));
        }


        int numA = numListA.size();
        int numB = numListB.size();

        for(int offset = 0; offset <= numB-numA; offset++){
            int totSum = 0;

            for( int i=0; i<numA; i++){
                totSum += numListA.get(i) * numListB.get(i+offset);
            }

            if(totSum > maxSum){
                maxSum = totSum;
            }
        }



        System.out.println(maxSum);
    }
}
