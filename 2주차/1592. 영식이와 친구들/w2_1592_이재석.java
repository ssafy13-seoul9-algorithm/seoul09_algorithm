import java.util.*;

public class BJ1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputString = input.split(" ");
        int length = Integer.parseInt(inputString[0]);
        int count = Integer.parseInt(inputString[1]);
        int dist = Integer.parseInt(inputString[2]);

        int[][] ballCountArray = new int[length][2];

        int idx = 0;
        int totCount = 0;
        ballCountArray[0][1]=1;
        // 게임의 count수보다 각 플레이어의 count수가 적을 때는,
        // ballCountArray+1, idx 및 totCount를 하단과 같이 처리한다.
        while(ballCountArray[idx][1] < count){
            idx = (idx + dist) % 5;
            ballCountArray[idx][1]+=1;
            totCount+=1;
            System.out.printf("idx:%d%n",idx);
            System.out.printf("ballCountArray:%d%n", ballCountArray[idx][1]);
            System.out.printf("totCount:%d%n",totCount);
        }

        System.out.println(totCount);

    }
}

//        for(int i=0 ; i<ballCountArray.length; i++){
//            System.out.printf("%d번째 사람", i+1);
//            if(ballCountArray[i][1] < count){
//
//                ballCountArray[i][1]+=1;
//            }else{
//
//            }
//
//        }


//        for(int i=0 ; i<ballCountArray.length; i++){
//            System.out.printf("%d번째 사람", i+1);
//            for(int j=0; j < ballCountArray[i].length; j++){
//                System.out.println(ballCountArray[i][j]);
//            }
//        }
