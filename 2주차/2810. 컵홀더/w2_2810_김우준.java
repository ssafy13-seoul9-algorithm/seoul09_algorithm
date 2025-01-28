import java.util.Scanner;

public class w2_2810_김우준 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] arr = sc.nextLine().split("");

        int max = 0;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            if (arr[i].equals("S")) {
                max += 1;
            }
            if (arr[i].equals("L")) {
                if(flag){
                    max += 2;
                    flag = false;
                } else {
                    max += 1;
                }
                i++;
            }
        }
        System.out.println(max);
    }
}