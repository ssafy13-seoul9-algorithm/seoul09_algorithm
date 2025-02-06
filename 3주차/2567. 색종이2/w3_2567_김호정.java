import java.util.Scanner;

public class w3_2567_김호정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[][] arr = new boolean[103][103];
        int cnt = 0;            // 총 둘레  

        int num = sc.nextInt(); // 몇 번 입력 받을지

        for(int a=0; a<num;a++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            for(int i=x;i<x+10;i++){
                for(int j=y;j<y+10;j++){
                    arr[i][j] = true;       // 색종이 있는 곳은 전부 true
                }
            }

        }
        
        // 둘레 구하기
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                if(arr[i][j]==true){
                    if(arr[i-1][j]==false) cnt+=1;
                    if(arr[i+1][j]==false) cnt+=1;
                    if(arr[i][j-1]==false) cnt+=1;
                    if(arr[i][j+1]==false) cnt+=1;
                }
            }
        }
        System.out.println(cnt);

    }
    
}
