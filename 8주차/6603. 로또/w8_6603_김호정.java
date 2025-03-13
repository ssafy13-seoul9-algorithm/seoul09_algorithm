
import java.util.Scanner;

public class w8_6603_김호정 {

    static int k;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            k = sc.nextInt();

            if (k == 0) {
                break;
            }

            arr = new int[k];
            result = new int[6];

            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }

            lotto(0, 0);
            System.out.println();
        }

    }

    static void lotto(int idx, int sidx) {
        // 종료 조건 - 6개 숫자 다 뽑아서 정답 배열의 마지막을 가리키게 된다면
        if (sidx == 6) {
            for (int i = 0; i < 6; i++) {   // 배열에 있는 숫자 하나씩 다 출력
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        // 재귀 부분
        for (int i = idx; i < k; i++) {
            result[sidx] = arr[i];       // 정답 배열에 입력된 숫자 배열에 있는 값을 넣어줌
            lotto(i + 1, sidx + 1);      // 중복을 방지한 조합을 위해 현재 i 이후 값만
        }
    }
}
