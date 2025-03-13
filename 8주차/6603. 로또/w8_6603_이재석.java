import java.util.*;

public class Main {
    static int[] arr, sel;
    static int N, S;


    public static void main(String[] args) {
        // 그러니까 k개의 숫자를 선택하고 그 중에서 6개의 숫자를 조합으로 선택하겠다는 말

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = 6;
        while(N != 0) {
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            sc.nextLine();

            // System.out.println(N);
            // System.out.println(Arrays.toString(arr));

            sel = new int[6];

            comb(0,0);

            // 하나의 로또 숫자에 대한 조합을 다 구했으면, 한 줄 띄어준다.
            System.out.println();

            // 새로운 숫자를 입력 받고 while문을 돈다.
            N = sc.nextInt();
        }


    }

    // 주어진 개수에 해당하는 모든 조합을 출력한다.
    public static void comb(int idx, int Sidx){
        if(Sidx == S){
            // System.out.println(Arrays.toString(sel));
            for(int i :sel){
                System.out.printf("%d ", i);
            }
            System.out.println();
            return;
        }

        if(idx == N){
            return;
        }

        // S번째 인덱스까지 sel 배열을 채워준다.
        sel[Sidx] = arr[idx];
        comb(idx+1, Sidx+1);

        // S 번째 인덱스까지 sel배열을 채워주면, 그 이전 스택 프레임으로 나와서 가장 마지막 인자를 바꿔준다.
        comb(idx+1, Sidx);

    }


}
