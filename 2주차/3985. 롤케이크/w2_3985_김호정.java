import java.util.Scanner;

public class w2_3985_김호정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();               // 롤케이크 길이
        int N = sc.nextInt();               // 사람 수
        int[] cake = new int[L + 1];        // 케이크 배열 (초기값 0)
        int[] real_count = new int[N + 1];  // 실제 받은 조각 수 저장

        int expect_max = 0;                 // 가장 많은 조각을 받을 것으로 예상되는 개수
        int expect_person = 0;              // 가장 많은 조각을 받을 것으로 예상되는 방청객 번호

        int real_max = 0;                   // 실제 가장 많은 조각을 받은 개수
        int real_person = 0;                // 실제 가장 많은 조각을 받은 방청객 번호

        for(int i=1;i<=N;i++){
            int P =sc.nextInt();                // 시작
            int K =sc.nextInt();                // 끝 
            int expected_pieces = K - P + 1;    // 예상 조각 개수

            if (expected_pieces > expect_max) { // 현재까지 최대 예상 조각 개수보다 큰 경우
                expect_max = expected_pieces;
                expect_person = i;
            } else if (expected_pieces == expect_max && i < expect_person) { // 만약 동점이라면 번호가 작은 방청객 선택
                expect_person = i;
            }

            for(int j=P;j<=K;j++){
                if(cake[j]==0){ // 배열이 0인 곳만 업데이트 
                    cake[j] = i;
                    real_count[i]++;
                }
            }
                        

        }
        
        // 실제로 가장 많은 조각을 받은 방청객
        for (int i = 1; i <= N; i++) {
            if (real_count[i] > real_max) { 
                real_max = real_count[i];   // 현재까지 최댓값보다 크면 갱신
                real_person = i;
            } else if (real_count[i] == real_max && i < real_person) {
                real_person = i;            // 동점 처리
            }
        }
        System.out.println(expect_person);
        System.out.println(real_person);
        sc.close();
    }
}