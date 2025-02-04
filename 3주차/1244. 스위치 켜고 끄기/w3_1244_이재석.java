import java.util.*;

public class BJ1244 {
    private static int lowPosition;
    private static int highPosition;

    public static void main(String[] args) {

        // 0 1 0 1 0 0 0 1
        // 남학생 : 자신이 받은 배수의 스위치 상태를 바꿔준다.
        // 여학생 : 자기 자신을 포함한, 좌우 대칭의 스위치 상태를 바꿔준다.


        Scanner sc = new Scanner(System.in);
        int switchNum =  sc.nextInt();
        sc.nextLine();

        String input =sc.nextLine();
        String[] switchArray =  input.split(" ");
        int[]  intSwitchArray = new int[switchNum];

        for(int i=0; i<switchNum; i++){
            intSwitchArray[i] = Integer.parseInt(switchArray[i]);
        }

        int studentNum = sc.nextInt();
        sc.nextLine();

        for (int i=0; i < studentNum; i++){
            String studentInput = sc.nextLine();
            String[] StudentArray = studentInput.split(" ");
            int[] intStudentArray = new int[2];

            for(int j=0; j<2; j++){
                intStudentArray[j]=Integer.parseInt(StudentArray[j]);
            }

            // 남학생일 경우, 배수에 해당하는 스위치를 바꿔준다.
            if (intStudentArray[0]==1){
                for(int j=0; j < switchNum; j++){
                    // 스위치의 인덱스가 남학생의 배수에 해당한다면, 숫자를 바꿔준다.
                    if((j+1) % intStudentArray[1] == 0 ){
                        if(intSwitchArray[j]==1){
                            intSwitchArray[j] = 0;
                        }else{
                            intSwitchArray[j] = 1;
                        }

                    }
                    
                }
            }
            // 여학생일 경우, 좌우 대칭된 스위치 중 가장 긴 길이에 해당하는 스위치들을 모두 바꿔준다.
            // 0 1 2 3 4 5 6 7
            // 0 1 1 1 0 1 0 1
            // j-2, j-1, j, j+1, j+2
            else if(intStudentArray[0]==2){
                int position = intStudentArray[1]-1;
                int[] intPositionArray = new int[switchNum];

                for (int j=1; j<=switchNum/2; j++){
                    lowPosition = position - j;
                    highPosition = position + j;
                    // 기본적으로 position은 바꿔야되는 스위치로 인식해야 한다.
                    intPositionArray[position]=1;
                    if ((0<=lowPosition && highPosition<switchNum) && (intSwitchArray[lowPosition] == intSwitchArray[highPosition])){
                        intPositionArray[lowPosition]=1;
                        intPositionArray[highPosition]=1;
                    }else{
                        break;
                    }
                }

//                lowPosition = position - 1;
//                highPosition = position + 1;
//                while(0<=lowPosition && highPosition<switchNum){
//                    if (intSwitchArray[lowPosition] == intSwitchArray[highPosition]){
//                        intPositionArray[lowPosition] = 1;
//                        intPositionArray[position] = 1;
//                        intPositionArray[highPosition] = 1;
//                        lowPosition-=1;
//                        highPosition+=1;
//                    }
//                }

                for(int j=0 ; j<intPositionArray.length;j++){
                    if(intPositionArray[j]==1){
                        if(intSwitchArray[j]==0){
                            intSwitchArray[j]=1;
                        }else{
                            intSwitchArray[j]=0;
                        }

                    }

                }
            }

        }

        //System.out.println(Arrays.toString(intSwitchArray));
        for(int i=0; i < switchNum;i++){
            System.out.print(intSwitchArray[i]);
            if (i < switchNum -1){
                System.out.print(" ");
            }
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }


    }
}


//                for(int j=1; j< switchNum/2; j++){
//                    lowPosition = position - j;
//                    highPosition = position + j;
//                    System.out.println(lowPosition);
//                    System.out.println(highPosition);
//                    while(0 <=lowPosition || highPosition>=switchNum) {
//                        if (intSwitchArray[lowPosition] == intSwitchArray[highPosition]) {
//                        intPositionArray[lowPosition] = 1;
//                        intPositionArray[highPosition] = 1;
//                        lowPosition-=1;
//                        highPosition-=1;
//                    }
//                }
//                }
//                System.out.println(Arrays.toString(intPositionArray));