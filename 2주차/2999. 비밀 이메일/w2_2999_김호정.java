import java.util.Scanner;

public class w2_2999_김호정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            
        String secret = sc.nextLine();
        int len = secret.length();
        int r = 0;

        // 약수 구하는 법
        for(int i = 1;i<=Math.sqrt(len);i++){
            if(len%i==0) r=i;
        }
        int c= len/r;

        String[][] ans = new String[c][r];
        
        // 가로 입력
        int a = 0;
        for(int i=0;i<c;i++){
            for(int j=0;j<r;j++){
                ans[i][j] = secret.charAt(a++) + "";
            }
        }

        // 세로 입력
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(ans[j][i]);
            }
        }


        sc.close();
    }
}

