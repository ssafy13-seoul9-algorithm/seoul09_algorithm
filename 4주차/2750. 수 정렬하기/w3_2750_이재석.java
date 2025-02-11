import java.util.*;

public class BJ2750 {
    public static void main(String[] args) {
        //단순 선택 알고리즘
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[] intArray = new int[n];

        for(int i=0; i<n; i++){
            intArray[i] = sc.nextInt();
        }

        //첫번째 인자에서 n-1번째 인자까지 확인한다.
        for(int i=0; i< n-1 ; i++){
            // 각 검사하는 원소마다 그 원소 뒤에 나오는 가장 작은 값의 인덱스를 찾고,
            // 해당 원소와 그 원소 뒤에 나오는 가장 작은 값의 위치를 바꿔준다.
            int min = i;
            for(int j= i+1; j < n; j++){
                if(intArray[min] > intArray[j]) {
                    min = j;
                }
            }

            int temp = intArray[i];
            intArray[i] = intArray[min];
            intArray[min] = temp;
        }

        for(int Int: intArray){
            System.out.println(Int);
        }

        //System.out.println(Arrays.toString(intArray));

    }
}
