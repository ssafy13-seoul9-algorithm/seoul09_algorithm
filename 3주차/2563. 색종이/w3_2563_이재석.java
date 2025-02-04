import java.util.*;

public class BJ2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //테스트 케이스의 개수를 입력 받는다.
        int testcase = sc.nextInt();
        sc.nextLine();

        //도화지 whiteSpace에 해당되는 칸을 칠한다.
        int[][] whiteSpace = new int[100][100];

        for(int i=0; i<testcase; i++){
            String input = sc.nextLine();
            String[] stringInput = input.split(" ");
            int len = stringInput.length;
            int[] integerInput = new int[len];

            for(int j=0; j < len; j++){
                int temp = Integer.parseInt(stringInput[j]);
                integerInput[j] = temp;
            }

            // 3 ~ 13, 7~17
            // 15 ~ 25, 7~17
            // 5 ~ 15, 2 ~ 12

            // stringInput = 3, 7

            for(int j = integerInput[0]; j < integerInput[0] + 10; j++){
                for(int k = integerInput[1]; k<integerInput[1] + 10; k++){
                    if(whiteSpace[j][k]==0) {
                        whiteSpace[j][k] = 1;
                    }
                }
            }
        }

        int count = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(whiteSpace[i][j] == 1){
                    count+=1;
                }
            }
        }

        System.out.println(count);



    }
}
