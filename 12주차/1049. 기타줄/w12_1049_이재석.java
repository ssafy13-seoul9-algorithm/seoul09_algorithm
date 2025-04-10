import java.util.*;

public class BJ1049 {
    // 끊어진 기타줄의 개수 N, 기타줄 브랜드 M개가 주어진다.
    // 적어도 N 개를 사기 위한 최소 가격을 구해라.
    // 일단 아이디어 자체는
    // 끊어진 기타줄이 6개 이하인데 패키지/ 낱개 > 6을 기준으로
    // 패키지나 낱개로 채울지 고민한다.

    // 동일하게 끊어진 기타줄이 6개 이상일 때 패키지/낱개 > 6 기준으로,
    // 패키지 가격이 가장 싼 것으로 6개씩 채우고,
    // 나머지는 낱개의 가격이 가장 낮은 것으로 채운다.

    // 이때 패키지 가격보다 낱개의 가격이 더 비싸면,
    // 그냥 패키지로 다 채우는 전략으로 간다.

    // N < 100, M < 50
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        // 기타 줄마다 패키지 및 낱개 가격을 받는다.
        int[][] arr = new int[M][2];
        int minPackage = Integer.MAX_VALUE;
        int minLine = Integer.MAX_VALUE;
        double minRatio = Integer.MAX_VALUE;
        double maxRatio = Integer.MIN_VALUE;
        int minRatIdx = -1;
        int maxRatIdx = -1;

        for(int i=0; i<M; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();

            if(arr[i][0] < minPackage)
                minPackage = arr[i][0];


            if(arr[i][1] < minLine)
                minLine = arr[i][1];


        }

        // System.out.println(Arrays.deepToString(arr));

        // 가장 싼 패키지 개수로 끊어진 기타줄을 채우고,
        // minPackage가 더 크다면 minLine으로 채우고 반대면 minPackage로 채운다.
        int sum = 0;
        if( minPackage < minLine * 6 ){
            int times = N/6 ;
            sum += minPackage * times;

            // 남은 기타줄에서 Package가 더 싸면 Package로 채우고,
            // Line이 더 싸다면 Line으로 채운다.
            int line = N % 6;
            if( minPackage < minLine * line){
                sum += minPackage;
            }else{
                sum += minLine * line;
            }
            System.out.println(sum);
        }
        // 패키지랑 낱개 중에서 더 싼 것을 고른다.
        else if(minPackage == minLine * 6){
            int packageOnly = ((N+5)/6) * minPackage;
            int lineOnly = N * minLine;

            System.out.println(Math.min(packageOnly, lineOnly));

        }
        // 낱개의 개수가 압도적으로 싸면 낱개로 전체 개수를 채운다.
        else{
            System.out.println(minLine * N);
        }

    }
}

// 12 2
// 12 1
// 15 4

