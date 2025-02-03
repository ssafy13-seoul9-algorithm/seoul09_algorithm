import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("");
        int cnt = 1;
        for(int i = 1; i < input.length; i++){
            cnt++;
            if(input[i].equals("=")){
                if(input[i-1].equals("z")){
                    if(i > 1){
                        cnt -= input[i-2].equals("d") ? 2 : 1;
                    } else {
                        cnt -= 1;
                    }
                } else {
                    cnt--;
                }
            } else if (input[i].equals("-")){
                cnt--;
            } else if (input[i].equals("j")){
                if(input[i-1].equals("l") || input[i-1].equals("n")){
                    cnt--;
                }
            }
        }

        System.out.println(cnt);
    }
}