import java.util.Scanner;

public class w1_1961_김우준 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(sc.nextLine());
            String arr[][][] = new String[4][n][n];
            
            for (int i = 0; i < n; i++) {
                arr[0][i] = sc.nextLine().split(" ");
            }
            
            for (int d = 1; d < 4; d++) {
                for (int i = n; i > 0; i--) {
                    for (int j = 0; j < n; j++) {
                        arr[d][j][i-1] = arr[d-1][Math.abs(i - n)][j];
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                System.out.println(String.join("", arr[1][i]) + " " + String.join("", arr[2][i]) + " " + String.join("", arr[3][i]));
            }

        }
    }
}