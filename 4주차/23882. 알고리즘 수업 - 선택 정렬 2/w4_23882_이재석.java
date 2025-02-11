import java.util.*;

public class BJ23882 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] countArray = new int[2];
        for(int i=0; i<2; i++){
            countArray[i] = sc.nextInt();
        }

        int len = countArray[0];
        int targetCount = countArray[1];
        int[] intArray = new int[len];
        for(int i=0; i<len ; i++){
            intArray[i] = sc.nextInt();
        }

        // 현재 검색하는 원소 뒤에서, 가장 작은 값을 가진 인덱스를 구하는 방법이다.
//        for(int i=0; i< len -1; i++){
//            // 현재 검색하는 원소 뒤에서, 가장 작은 값을 가진 원소의 인덱스를 구한다.
//            int min = i;
//            for(int j= i+1; j<len; j++){
//                if(intArray[min]>intArray[j]){
//                    min = j;
//                }
//            }
//            // 가장 작은 값의 인덱스를 구했으면, 검색한 원소와 가장 작은 값의 위치를 바꾼다.
//            int temp = intArray[i];
//            intArray[i] = intArray[min];
//            intArray[min] = temp;
//        }

        // 가장 뒤에서부터, 나의 앞에 있는 원소 중 큰 원소를 뒤로 가져온다.
        int count =0;
        int[] resultArray = new int[len];
        for(int i = len-1; i >= 1; i--){
            // 현재 검색하는 원소 앞에서, 가장 큰 값을 가진 원소를 가진 인덱스를 구한다.
            // 가장 큰 값을 가진 원소 인덱스를 구했으면, 현재 원소와 가장 큰 값을 가진 원소의 위치를 바꾼다.
            int max = i;
            for(int j= i- 1; j >= 0 ; j--){
                if(intArray[max]<intArray[j]){
                    max = j;
                }
            }

            int temp = intArray[i];
            intArray[i] = intArray[max];
            intArray[max] = temp;
            // 현재 원소에서 나보다 앞에 있는 원소 중 더 큰 값을 발견했을 때만, 교환 횟수를 올린다.
            if(max !=i){
                count+=1;
            }

            if(count == targetCount){
                //System.out.println(count);
                // 단순히 배열의 참조값을 복사하는 얕은 복사가 아니라,
                // 값 자체를 아예 새로운 주소고 복사하는 깊은 복사를 해야 한다.
                // 그렇게 하지 않고 얕은 복사만 진행하게 되면,
                // resultArray는 주소값을 복사하기 때문에 정렬이 완료된 intArray를 출력하게 되는 것이지
                // 내가 원하는 현재 정렬된 값의 intArray를 출력하지 못한다.
                resultArray = Arrays.copyOf(intArray, intArray.length);
                //                System.out.println(Arrays.toString(intArray));
            }


        }

//        for(int i=0; i<len; i++){
//            System.out.println(intArray[len-1-i]);
//        }

        // 총 교환 횟수가 목표 횟수보다 작으면 -1을 출력한다.
        if(count < targetCount){
            System.out.println(-1);
        }else{
            for(int i=0; i<len; i++){
                if(i!=len-1){
                    System.out.printf("%d ", resultArray[i]);
                }else{
                    System.out.printf("%d", resultArray[i]);
                }

            }
        }

//        System.out.println(Arrays.toString(resultArray));
//        System.out.println(Arrays.toString(intArray));


    }
}
