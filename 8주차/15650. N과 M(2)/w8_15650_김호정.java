import java.util.Scanner;

public class w8_15650_김호정 {
    
    static int N;
    static int M;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        result = new int[M];
        comb(0, 1);
    }

    // 순열
    static void comb(int idx, int sidx) {
        // 종료 조건
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return; // 스택에서 연산을 하나씩 빼면서 다시 원래 상태로 돌아가기
        }

        // 재귀조건
        for (int i = sidx; i <= N; i++) {
            result[idx] = i;
            comb(idx + 1, i + 1);
        }
    }
}
