import java.util.Scanner;

public class w1_2058_김우준 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        char[] num_arr = num.toCharArray();
        int result = 0;

        for (int i = 0; i < num.length(); i++) {
            result += Character.getNumericValue(num_arr[i]);
        }

        System.out.println(result);
    }
}