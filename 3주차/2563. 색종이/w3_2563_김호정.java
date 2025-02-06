import java.util.Scanner;

public class w3_2563_김호정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[100][100];
        int square = 0;     // 총 면적

        int num = sc.nextInt(); // 몇 번 입력 받을지

        for(int a=0; a<num;a++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            for(int i=x;i<x+10;i++){
                for(int j=y;j<y+10;j++){
                    arr[i][j]++;
                    if(arr[i][j]==1){
                        square++;
                    }
                }

            }
        }
        System.out.println(square);


    }
}