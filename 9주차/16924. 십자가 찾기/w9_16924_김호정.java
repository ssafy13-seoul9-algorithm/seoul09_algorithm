
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class w9_16924_김호정 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        List<int[]> xys = new ArrayList<>(); // 발견된 십자가 리스트
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                int x = i;
                int y = j;
                if (board[i][j] == '*') {
                    int croseSize = 0;
                    while (true) {
                        croseSize++;
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = x + dx[dir] * croseSize;
                            int ny = y + dy[dir] * croseSize;
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] != '*') {

                            }
                        }
                    }
                }
            }

        }
    }

}
