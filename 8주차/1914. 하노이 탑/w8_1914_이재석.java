import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        // 2^N - 1 계산 (BigInteger 사용)
        BigInteger count = BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE);
        System.out.println(count); // 이동 횟수 출력

        // N이 20 이하일 때만 하노이 탑 이동 과정 출력
        if (N <= 20) {
            StringBuilder sb = new StringBuilder();
            hanoi(1, 3, 2, N, sb);
            System.out.print(sb.toString()); // 한 번에 출력
        }
    }

    // 하노이 재귀 함수 (StringBuilder 사용)
    static void hanoi(int start, int end, int aux, int N, StringBuilder sb) {
        if (N == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        hanoi(start, aux, end, N - 1, sb);
        sb.append(start).append(" ").append(end).append("\n");
        hanoi(aux, end, start, N - 1, sb);
    }
}
