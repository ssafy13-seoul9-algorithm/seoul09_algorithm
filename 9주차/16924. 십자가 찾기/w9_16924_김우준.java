import java.util.Scanner;

public class w9_16924_김우준 {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int N;
    static char[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(check(i, j)){
                    // 십자가 라면 list로 저장해서 관리
                }
            }
        }

        System.out.println(); // list.size()로 십자가 개수
        // for(int[] arr : list){
        //      대충 저장된 위치 sysout
        // }
        
    }

    static boolean check(int x, int y){
        int idx = 1;
        boolean status = true;
        while(x - idx >= 0 && x + idx < N && board[x-idx][y] == '*'){
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i] * idx;
                int ny = y + dy[i] * idx;
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(board[nx][ny] != '*'){
                    status = false;
                    break;
                }
            }
            if(!status) return status;
            idx++;
        }

        return status;
    }
}
