import java.util.Scanner;

public class App {
    static int N;
    static int M;
    static int[] seq;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        seq = new int[M];

        recur(1, 0);
    }

    public static void recur(int num, int idx){
        if(idx == M){
            // 만약 인데스가 M개 까지 도달한 경우 탈출
            for(int i = 0; i < seq.length; i++){
                System.out.print(seq[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = num; i <= N; i++){
            // 수열 배열에 숫자 저장
            seq[idx] = i;
            recur(i + 1, idx + 1);
        }
    }
}
