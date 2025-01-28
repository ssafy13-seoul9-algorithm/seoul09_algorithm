import java.util.Scanner;

public class w2_2851_김우준 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 100;
        int sum = Integer.parseInt(sc.nextLine());
        int current = 0;
        for(int i = 0; i < 9; i++){
            current = Integer.parseInt(sc.nextLine());
            if (sum + current >= max) {
                sum = Math.abs(sum - max) >= Math.abs(sum + current - max) ? sum + current : sum;
                break;
            } else {
                sum += current;
            }
        }
        System.out.println(sum);
    }
}
