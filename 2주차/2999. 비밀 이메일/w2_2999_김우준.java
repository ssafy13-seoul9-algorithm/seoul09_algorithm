import java.util.Scanner;

public class w2_2999_김우준 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("");
        int R = 0;
        int C = 0;

        outer: for (int i = input.length; i > 0; i--) {
            for (int j = input.length; j >= i; j--) {
                if (i * j == input.length) {
                    R = i;
                    C = j;
                    break outer;
                }
            }
        }
        String[][] arr = new String[C][R];
        int idx = 0;
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                arr[i][j] = input[idx++];
            }
        }
        for (int j = 0; j < R; j++) {
            for (int i = 0; i < C; i++) {
                System.out.print(arr[i][j]);
            }
        }
    }
}