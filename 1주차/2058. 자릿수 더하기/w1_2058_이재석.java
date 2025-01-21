import java.util.Scanner;

public class SWEA2058 {

    public static void main(String[] args){
        System.out.println("숫자를 입력하세요");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int sum = 0;

        for (char c: input.toCharArray()){
            int digit = Character.getNumericValue(c);
            sum+=digit;
        }

        System.out.println(sum);


    }
}