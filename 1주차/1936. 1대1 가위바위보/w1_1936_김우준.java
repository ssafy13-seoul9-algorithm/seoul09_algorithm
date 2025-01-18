import java.util.Scanner;

public class w1_1936_김우준 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a > b) {
            System.out.println(a == 3 && b == 1 ? "B" : "A");
        } else if (b > a) {
            System.out.println(b == 3 && a == 1 ? "A" : "B");
        }
    }
}