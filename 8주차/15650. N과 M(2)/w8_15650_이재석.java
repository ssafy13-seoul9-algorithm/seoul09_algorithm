import java.util.*;

public class Main {

    static int[] tot, sel;
    static int N,S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        tot = new int[N];
        sel = new int[S];

        // tot에 해당하는 전체 숫자 배열을 만들어준다.
        for(int i=1; i<=N; i++){
            tot[i-1] = i;
        }

        comb(0,0, tot, sel);

    }

    public static void comb(int idx, int Sidx, int[] tot, int[] sel){
        // 해당되는 조합의 개수만큼 뽑았으면, 출력한다.
        if(Sidx== S){
            // System.out.println(Arrays.toString(sel));
            for(int i: sel){
                System.out.printf("%d ", i);
            }
            System.out.println();
            return;
        }

        // 전체 조합의 개수만큼 뽑았으면 함수를 종료한다.
        if(idx == N){
            return;
        }

        // 전체 배열에서 2개 숫자를 뽑아서 조합을 만든다고 가정한다.
        // 전체 배열 tot에서 첫번째 숫자를 골라서, sel에 넣는다.
        // tot에서 두번째 숫자를 골라서, sel에 넣는다.
        sel[Sidx] = tot[idx];
        comb(idx+1, Sidx+1, tot, sel);

        // 해당되는 조합의 개수만큼 뽑고 호출한 스택함수에서 빠져 나오면, 2번째 조합을 다시 고르는 과정을 거친다.
        comb(idx+1, Sidx, tot, sel);




    }
}
