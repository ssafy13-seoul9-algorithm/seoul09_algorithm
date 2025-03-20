import java.util.Scanner;

public class w9_1331_김호정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[][] visited = new boolean[6][6];
        String[] loca = new String[36];

        // 36번 위치를 다 저장해두기
        for (int i = 0; i < 36; i++) {
            loca[i] = sc.nextLine();
        }

        // 1st 위치
        int startX = loca[0].charAt(0) - 'A';
        int startY = loca[0].charAt(1) - '1';

        int prevX = startX;
        int prevY = startY;
        visited[startX][startY] = true;

        for (int i = 1; i < 36; i++) {
            // 첫 번째 위치 제외하고 이제 반복문 돌면서 탐색 시작
            int curX = loca[i].charAt(0) - 'A';
            int curY = loca[i].charAt(1) - '1';

            if (visited[curX][curY] == true) {
                System.out.println("Invalid");
                break;
            }

            // x좌표, y좌표끼리의 차이 절대값 -> (1,2) or (2,1)
            int diffX = Math.abs(curX - prevX);
            int diffY = Math.abs(curY - prevY);

            if (!(diffX == 1 && diffY == 2) || !(diffX == 2 && diffY == 1)) {
                System.out.println("Invalid");
                break;
            }

            visited[curX][curY] = true;
            prevX = curX;
            prevY = curY;
        }
    }
}
