import java.util.Scanner;

public class w1_1959_김우준 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            int lengthA = sc.nextInt();
            int lengthB = sc.nextInt();
            int arrA[] = new int[lengthA];
            int arrB[] = new int[lengthB];

            for (int i = 0; i < lengthA; i++) {
                arrA[i] = sc.nextInt();
            }
            for (int i = 0; i < lengthB; i++) {
                arrB[i] = sc.nextInt();
            }

            int arrLong[];
            int arrShort[];

            if (lengthA > lengthB) {
                arrLong = arrA;
                arrShort = arrB;
            } else {
                arrLong = arrB;
                arrShort = arrA;
            }

            int max = 0;
            int sum = 0;

            for (int i = 0; i < arrLong.length - arrShort.length + 1; i++) {
                sum = 0;
                for (int j = 0; j < arrShort.length; j++) {
                    sum += arrShort[j] * arrLong[j + i];
                }
                if (sum > max)
                    max = sum;
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}