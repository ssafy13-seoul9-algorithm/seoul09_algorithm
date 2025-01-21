import java.util.*;
import java.lang.*;

public class SWEA1961 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("테스트 케이스의 개수를 입력하세요.");
        int testcase = sc.nextInt();
        for(int i =0; i < testcase; i++){
            int n = sc.nextInt();

            //배열 형성
            int[][] array = new int[n][n];

            for (int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    array[j][k] = sc.nextInt();
                }
            }

            System.out.printf("#%d", i+1);
            System.out.println();

            for(int j=0; j<n; j++){
                StringBuilder sb = new StringBuilder();
                for (int k=0; k<n; k++) {
                    sb.append(array[n - 1 - k][j]);
                }
                sb.append(" ");
                for (int k=0; k<n; k++){
                    sb.append(array[n- 1- j][n-1-k]);
                }
                sb.append(" ");
                for (int k=0; k<n; k++){
                    sb.append(array[k][n-1-j]);
                }



                System.out.println(sb);
            }




        }

//        for(int j=0; j< n ; j++){
//            for (int k=0; k < n; k++){
//                for( int l=n-1; l>=0; l--){
//                    int temp = Integer.parseInt(sb.append(array[l][j]).toString());
//                }
//                array[k][j] = temp;
//            }
//
//        }

    }
}

//        int[][] array = new int[8][9];
//
//        for (int i=2; i<10; i++){
//            for (int j=1; j<10; j++){
//                array[i-2][j-1] = i * j;
//            }
//        }
//        System.out.println(array);
//
//        for (int i=0; i< array.length; i++){
//            System.out.println((i+2) + "단");
//            System.out.println(Arrays.toString(array[i]));
//            System.out.println();
//        }