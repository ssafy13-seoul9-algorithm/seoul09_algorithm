import java.util.*;

public class BJ24051 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int[] countArray = new int[2];
       for(int i=0; i<2; i++){
           countArray[i] = sc.nextInt();
       }

       int num = countArray[0];
       int changeNum = countArray[1];
       int[] intArray = new int[num];
       for(int i=0; i<num; i++){
           intArray[i] = sc.nextInt();
       }

       int count = 0;
       int result = -1;
       // 1번째 원소부터 확인을 해서, 자신보다 큰 숫자가 있으면 뒤로 미룬다.
       for(int i=1; i<num; i++){
            int j = i;
            int temp = intArray[i];
            while(j>0 && intArray[j-1] > temp){
                intArray[j] = intArray[j-1];
                count++;
                // j인덱스의 값을 내리기 전에 count 조건을 확인해서, 저장된 값을 확인해야 한다.
                if(count == changeNum){
                    result = intArray[j];
                }
                System.out.printf("%d, %d, %d%n", count, intArray[j],j);
                j--;;
                //System.out.printf("count %d", count);


            }

            // 그리고 자신 보다 더 이상 큰 숫자가 없다면, 해당 자리에 숫자를 삽입한다.
            // 여기에서도 인덱스에 저장한 값을 확인하려면, count++를 하기 전에 확인해야 한다.
            // ㅋㅋ 이걸 어떻게 알아
            // 그러니까 정렬이 필요하지 않는데 intArray[j]에 temp를 넣게 될 시 count가 증가하는 현상을 방지하기 위해서,
            // 서로 인덱스가 다를 때만 count 횟수를 올린다.
           if(j!=i){
                intArray[j] = temp;
                count++;
                if(count == changeNum){
                    result = intArray[j];
                }
                System.out.printf("%d, %d, %d%n", count, intArray[j],j);

            }
//           if(count < (Math.pow(num,2) - num)/2){
//            count++;
//           }


           //System.out.printf("count %d", count);

       }
        //System.out.println(count);
        //System.out.println(changeNum);


        if(count >= changeNum){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }


    }
}
