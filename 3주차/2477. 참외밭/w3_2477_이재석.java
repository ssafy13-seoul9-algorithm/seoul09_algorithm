import java.util.*;

public class BJ2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fruitNum = sc.nextInt();
        sc.nextLine();

        int totLen = 6;
        int eleLen = 2;
        int[][] squareArray = new int[totLen][eleLen];

        for(int i=0; i < 6; i++){
            String input = sc.nextLine();
            String[] stringInput = input.split(" ");
            int[] integerInput = new int[totLen];
            for(int j=0; j < eleLen; j++){
                integerInput[j] = Integer.parseInt(stringInput[j]);
            }
            squareArray[i] = integerInput;
        }


        int[][] countArray = new int[totLen][eleLen];

//        int idx1 = -1;
//        int idx2 = -1;
//
//        for (int i = 0; i < totLen; i++) {
//            boolean found = false; // 숫자가 이미 존재하는지 확인
//
//            // countArray에 이미 존재하는지 체크
//            for (int j = 0; j < totLen; j++) {
//                if (squareArray[i][0] == countArray[j][0]) {
//                    countArray[j][1]++; // 등장 횟수 증가
//                    found = true;
//                    break; // 이미 찾았으므로 더 이상 체크할 필요 없음
//                }
//            }
//
//            // 새 숫자라면 countArray에 추가
//            if (!found) {
//                for (int j = 0; j < totLen; j++) {
//                    if (countArray[j][1] == 0) { // 빈 공간 찾기
//                        countArray[j][0] = squareArray[i][0];
//                        countArray[j][1] = 1;
//                        break;
//                    }
//                }
//            }
//        }
//
//        // 2번 등장한 방향 찾기
//        for (int j = 0; j < totLen; j++) {
//            if (countArray[j][1] == 2) {
//                if (idx1 == -1) {
//                    idx1 = j;
//                } else {
//                    idx2 = j;
//                }
//            }
//        }

        // idx1, idx2 디버깅 필요
        int idx1 = -1;
        int idx2 = -1;
        int temp = -1;

        for(int i = 0; i<totLen; i++){
            for(int j=0; j<totLen; j++) {
                // 서로 다른 숫자인 경우, 숫자를 countArray 배열에 추가한다.

                if (squareArray[i][0] != countArray[j][0] && countArray[j][1] == 0) {
                    countArray[j][0] = squareArray[i][0];
                    countArray[j][1] += 1;
                    break;
                }
                // 서로 같은 숫자인 경우, 이미 있는 countArray의 배열에서 횟수를 올린다.
                else if (squareArray[i][0] == countArray[j][0]) {
                    temp = (j + 2 ) % 6;
                    countArray[temp][1] += 2;
                    System.out.println(temp);
                    break;
                }
            }

        }

        for(int j=0; j<totLen; j++){
            //2번 세어진 idx를 각각 idx1, idx2에 저장한다.
            if(idx1 == -1 && countArray[j][1]==2){
                idx1 = j;
            }else if(idx1 != -1 && countArray[j][1]==2){
                idx2 = j;
            }

//            System.out.println(idx1);
//            System.out.println(idx2);
        }

        // 2번 세어진 방향의 1번째 숫자를 0으로 만들어준다.
        if(idx1!=-1 && idx2!=-1){
            for(int j=0; j<totLen; j++){
                if(countArray[j][0] == countArray[idx1][0]){
                    countArray[j][1] = 0;
                }else if(countArray[j][0] == countArray[idx2][0]){
                    countArray[j][1] = 0;
                }
            }
        }

        int startIdx = -1;
        int resultIdx = -1;
        for(int i=0; i < totLen; i++){
            //if(countArray[i][1]==1 && (countArray[0][1] !=1 && countArray[1][1]!=0)){
            if(countArray[i][1]==1 && (countArray[0][1] !=1 || countArray[totLen-1][1]!=1)){
                    startIdx = i;
                    resultIdx = (startIdx+3) % 6;
                    break;
            }
            //else if(countArray[i][1] == 1 && (countArray[0][1] ==1 && countArray[1][1]==0)){
            else if(countArray[i][1] == 1 &&  (countArray[0][1] ==1 && countArray[totLen-1][1]==1)){
                    startIdx = totLen-1;
                    resultIdx = (startIdx+3) % 6;
            }

        }

        int smallIdx1 = (resultIdx) % 6;
        int smallIdx2 = (resultIdx + 1 + 6) %6;

        int bigIdx1 = (startIdx)%6;
        int bigIdx2 = (startIdx +1 + 6) %6;

        int bigRec = -1;
        int smallRec = -1;
        bigRec = squareArray[bigIdx1][1]*squareArray[bigIdx2][1];
        smallRec = squareArray[smallIdx1][1]*squareArray[smallIdx2][1];

        int result =-1;
        result = fruitNum*(bigRec-smallRec);

        System.out.println(Arrays.deepToString(countArray));
        System.out.println(result);

//        // 0-> 3
//           1  1  0  0  2  2
//        // 4, 2, 3, 1, 3, 1
//
//        // 5 -> 2
//           1  0  0  2  2  1
//        // 2, 3, 1, 3, 1, 4
//           0  0  2  2  1  1
//        // 3, 1, 3, 1, 4, 2
//           0  0  2  1  1  2
//        // 1, 3, 1, 4, 2, 3
//           0  0  1  1  2  2
//        // 3, 1, 4, 2, 3, 1
//           0  1  1  0  2  2
//        // 1, 4, 2, 3, 1, 3

//         1, 2 - 동, 서 & 3, 4 - 남, 북
// 우1 4 50
// 상  2 160
// 좌  3 30
// 하1 1 60
// 우2 3 20
// 하  1 100






    }
}
