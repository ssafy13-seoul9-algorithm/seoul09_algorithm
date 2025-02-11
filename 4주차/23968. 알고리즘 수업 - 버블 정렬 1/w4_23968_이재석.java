import java.util.*;

public class BJ23968 {
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

        int count =0;
        int[] resultArray = new int[2];
        for(int i=0; i<len -1; i++){
            for(int j=0; j<len -1 -i; j++){
                if (intArray[j]> intArray[j+1]){
                    int temp = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = temp;
                    count+=1;

                    if(count == targetCount){
                        resultArray[0] = intArray[j];
                        resultArray[1] = intArray[j+1];
                    }
                }
            }
        }

        if(resultArray[0]!=0){
            for(int i=0; i<2; i++){
                if(i==0)
                    System.out.printf("%d ", resultArray[i]);
                else if(i==1)
                    System.out.printf("%d", resultArray[i]);
            }

        }else if (resultArray[0] == 0){
            System.out.println(-1);
        }

        //System.out.println(count);
        //System.out.println(Arrays.toString(countArray));
        //System.out.println(Arrays.toString(intArray));




    }
}
