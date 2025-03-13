import java.util.Scanner;

public class Main {
    static int N;
    static int cnt;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        N = Integer.parseInt(sc.nextLine());
        
        queen(0, 0, 0, 0);

        System.out.println(cnt);
    }

    static void queen(int idx, int qStatus, int lStatus, int rStatus){
        if(idx == N){
            cnt++;
            return;
        }
        // 현재 퀸이 놓인 곳과, 대각처리된 부분 비트 마스킹
        int cur = qStatus | lStatus | rStatus;
        for(int i = 0; i < N; i++){
            if((cur & 1<<i) != 0) continue;
            // 만약 현재 위치에서 퀸을 놓을 수 있다면,
            // 현재 위치와 현재 위치의 좌우 비트 마스킹 추가(이전 비트마스킹도 유효 하므로 전체 마스킹 쉬프팅)
            int lv = lStatus | 1<<i;
            int rv = rStatus | 1<<i;
            queen(idx + 1, qStatus | (1<<i), lv<<1, rv>>1);
        }
    }
}