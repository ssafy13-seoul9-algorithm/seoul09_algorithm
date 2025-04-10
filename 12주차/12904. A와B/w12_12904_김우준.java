import java.util.Scanner;

public class w12_12904_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        String T = sc.nextLine();

        int result = 0;

        int len = T.length();
        for(int i = 0; i < len; i++){
            if(T.charAt(T.length() - 1) == 'A'){
                T = new StringBuilder(T).deleteCharAt(T.length() - 1).toString();
            } else {
                T = new StringBuilder(T).deleteCharAt(T.length() - 1).reverse().toString();
            }
            if(T.equals(S)){
                result = 1;
                break;
            }
        }

        System.out.println(result);
    }
}
