import java.util.Scanner;

public class BJ1806 {
    // 5 1 3 5 10 7 4 9 2 8
    static int[] arr;
    static int min;
    static int N, S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int result = findShortestSum(S);
        System.out.println(result);

    }

    static int findShortestSum(int S){
        boolean findShortestSum = false;
        int s = 0;
        int e = 0;

        min = Integer.MAX_VALUE;
        int cnt = 0;


        while( s <= e ){
            // sum은 s 번째 idx 에서 e번째 idx까지의 합이다.
            int sum = 0;
            for(int i = s; i <= e; i++){
                sum += arr[i];
            }

            // s ~ e 번째 idx 숫자의 개수를 구한다.
            cnt = e - s + 1;

            // 숫자의 합이 주어진 합보다 클 경우, 왼쪽의 포인터를 옮긴다.
            if( sum >= S ){
                s++;
                if(cnt < min) {
                    findShortestSum= true;
                    min = cnt;
                }
            }
            // 숫자의 합이 주어진 합보다 작을 경우, 오른쪽으로 포인터를 늘려간다.
            else if( sum < S ){
                e++;
                // idx가 전체 배열을 넘어가면, while문을 벗어난다.
                if(e >= N)
                    break;
            }

            /*
                else if(sum > S){
                    s--;
                }
            */

        }

        // System.out.printf("%d %d\n", s, e);

        return findShortestSum? min: 0;

    }

}
