import java.util.Arrays;
import java.util.Scanner;

public class w8_6603_김우준 {
    static int[] lotto;
    static int[] result;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // stream으로 한번에 입력
            lotto = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 입력값 [0]번 인덱스가 0인 경우 종료
            if(lotto[0] == 0) break;
            // 결과 저장용 배열, 번호 6개 까지만
            result = new int[6];
            recur(1, 0);
            System.out.println();
        }
    }

    public static void recur(int idx, int cidx) {
        if (cidx == 6) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i <= lotto[0]; i++) {
            // lotto 가능성 있는 번호 결과[cidx]에 저장후 인덱스 + 1
            result[cidx] = lotto[i];
            recur(i + 1, cidx + 1);
        }
    }
}