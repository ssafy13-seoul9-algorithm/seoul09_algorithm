import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[5][5];

        for(int i = 0; i < 5; i++){
            arr[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        String[] input = sc.nextLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        System.out.println(bfs(arr, x, y));
    }

    static int bfs(int[][] arr, int startX, int startY){
        Queue<Board> queue = new LinkedList<>();

        int[][] nArr = new int[5][5];
        for(int n = 0; n < 5; n++){
            nArr[n] = Arrays.copyOf(arr[n], 5);
        }

        queue.offer(new Board(nArr, startX, startY, 0, 0));
        
        while(!queue.isEmpty()){
            Board cur = queue.poll();
            int[][] board = cur.board;
            int xC = cur.x;
            int yC = cur.y;
            int mC = cur.move;
            int apple = cur.apple;

            if(apple == 3){
                return mC;
            }

            board[xC][yC] = -1;
            
            for(int i = 0; i < 4; i++){
                int nx = xC + dx[i];
                int ny = yC + dy[i];
                
                if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && board[nx][ny] != -1){
                    int[][] nBoard = new int[5][5];
                    for(int n = 0; n < 5; n++){
                        nBoard[n] = Arrays.copyOf(board[n], 5);
                    }
                    int nApple = board[nx][ny] == 1 ? apple + 1 : apple;
                    queue.offer(new Board(nBoard, nx, ny, mC + 1, nApple));
                    
                }
            }
        }

        return -1;
    }

    // 현재 보드 상태 저장용 클래스
    static class Board {
        int[][] board;
        int x;
        int y;
        int move;
        int apple;

        Board(int[][] borad, int x, int y, int move, int apple){
            this.board = borad;
            this.x = x;
            this.y = y;
            this.move = move;
            this.apple = apple;
        }
    }
}
