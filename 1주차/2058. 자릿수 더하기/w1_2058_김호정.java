import java.util.Scanner;

public class w1_2058_김호정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int b = a/1000;
        int c = (a/100) % 10;
        int d = (a/10) % 10;
        int e = a % 10;

        System.out.println(b+c+d+e);
        sc.close();
    }
    
}
