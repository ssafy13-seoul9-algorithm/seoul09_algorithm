import java.util.Scanner;

public class w9_22858_김호정 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N]; // 결과로 나온 값들
        int[] D = new int[N];   // 카드 이동 인덱스 적힌 D 배열
        int[] reverse = new int[N]; // D 역순한 배열

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            D[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            reverse[D[i] - 1] = i;  // 카드의 값으로 들어오는건 1부터 시작이니까 1을 빼야 됨
        }

        for (int i = 0; i < K; i++) {
            int[] tmp = new int[N];     // 임시로 새 배열을 생성해두고 

            for (int j = 0; j < N; j++) {
                //   tmp[reverse[j]] = arr[j];   // 그 임시 배열에 결과 값으로 나왔던 값을 역순으로 찾아서 넣음
                tmp[j] = arr[reverse[j]];
            }

            // arr = Arrays.copyOfRange(tmp, 0, N);        // 임시 배열 다시 복사해서 원해 있던 배열을 갱신
            arr = tmp;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
