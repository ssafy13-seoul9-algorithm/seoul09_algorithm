//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.util.Scanner;

public class SWEA1936 {
    public static void main(String[] args) {
        // 가위 = 1, 바위 = 2, 보 = 3
        //    Scanner sc = new Scanner(System.in);

        System.out.println("A,B가 내는 값을 입력 받아보자(가위 = 1, 바위 = 2, 보 = 3)");
        Scanner sc = new Scanner(System.in);

        System.out.println("A가 내는 값");
        int A = sc.nextInt();
        System.out.println("B가 내는 값");
        int B = sc.nextInt();

//        System.out.println("A가 입력한 숫자는"+ A);
//        System.out.println("B가 입력한 숫자는"+ B);

        if(A==B){
            System.out.println("무승부입니다.");
        }else if((A==1 & B==3)||(A==2 & B==1)||(A==3 & B==2)){
            System.out.println("A");
        }else{
            System.out.println("B");
        }

    }
}