import java.util.Scanner;

public class w2_8320_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            for(int j = i; j <= N; j++){
                if(i * j <= N){
                    cnt++;
                } else {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
