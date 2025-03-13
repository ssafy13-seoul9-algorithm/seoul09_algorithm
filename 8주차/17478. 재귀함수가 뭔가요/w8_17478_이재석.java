import java.util.*;

public class Main {
    static int len ;
    static String add = "____";
    static String[] str;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String start  = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";

        str = new String[] {
                "\"재귀함수가 뭔가요?\"",
                "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
                "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
                "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};
        len = str.length;

        System.out.println(start);
        print(N,0);

    }

    static void print(int N, int times){
        String[] str1 = {"\"재귀함수가 뭔가요?\"", "\"재귀함수는 자기 자신을 호출하는 함수라네\""};
        int len1 = str1.length;
        String str2 = "라고 답변하였지.";
        String prefix = add.repeat(times);

        // 재귀함수를 끝까지 다 들어갔으면, 재귀함수가 뭔가요와 응답을 출력하고,
        // 라고 답변하였지.를 출력한다.
        if(N==0){
            for(int i=0; i < len1; i++){
                System.out.println(prefix + str1[i]);
            }
            
            for(int i = times ; i >= 0; i--){
                System.out.printf(add.repeat(i));
                System.out.println(str2);
            }

            return;
        }

        // 질문 및 이야기 출력

        for(int i= 0; i<len; i++){
            System.out.print(prefix);
            System.out.println(str[i]);
        }


        // 출력하는 횟수를 1 차감하고, prefix에서 add를 출력하는 횟수를 한번 더한다.
        print(N-1, times+1);

        // 라고 답변하였지.를 재귀함수를 탈출할 때 출력한다.
        // System.out.println(prefix + str2);

    }

}
