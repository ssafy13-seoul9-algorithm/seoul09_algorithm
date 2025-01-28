import java.util.Scanner;

public class w2_2851_김호정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[10];
        int sum = 0;
        int pre = 0;     // sum 이전 값

        for (int i = 0; i < 10; i++) {
            num[i] = sc.nextInt();
        }


        for (int i = 0; i < 10; i++) {
            pre = sum;  // 이전 값 저장
            sum += num[i];

            if (sum == 100) { 
                System.out.println(sum);
                return;
            }

            if (sum > 100) {
                if (Math.abs(100 - sum) < Math.abs(100 - pre)) {
                    System.out.println(sum);
                } else {
                    System.out.println(pre);
                }
                return; 
            }
        }

        System.out.println(sum);
    }
}


