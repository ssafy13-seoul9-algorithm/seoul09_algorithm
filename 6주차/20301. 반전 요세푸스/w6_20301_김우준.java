import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);

        // 리스트 생성
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        // 초기 위치, 횟수, 방향 선언
        int pos = 0;
        int cnt = 0;
        int dir = 1;
        // 리스트가 빌 때 까지
        while(!list.isEmpty()){
            // 반시계 방향인 경우, 왼쪽 기준으로 돌아야 하기에 pos -1
            if(dir < 0) pos--;
            pos = (pos + dir * (K - 1)) % list.size();
            // pos 음수 처리리
            if(pos < 0) pos += list.size();
            System.out.println(list.remove(pos));
            // M 회 수행되면 방향 전환
            if(++cnt == M) {
                cnt = 0;
                dir *= -1;
            }
        }
    }
}