import java.util.*;

public class BJ16924 {
    // 아이디어 자체는 .만 남아 있을 경우에만, 십자가의 크기 출력하는 것을 멈춘다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char[][] charArr = new char[N][M];
        for(int i=0 ; i<N; i++){
            charArr[i] = sc.nextLine().toCharArray();
        }

        // *가 들어 있는 곳을 -1 만큼 처리하고, 하나의 원소라도 1이 존재한다면 실패 처리한다.
        int[][] intArr = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M ; j++){
                if(charArr[i][j]=='*'){
                    intArr[i][j] = 1;
                }else{
                    intArr[i][j] = 0;
                }

            }
        }

        // 각 행마다 십자가를 처리할 수 있는지 확인한다.
        // 십자가의 중심을 기준으로, 위 아래 양 옆으로 *가 존재하는지 확인한다.
        // 작은 크기의 십자가부터 처리해서, *를 다 처리할 수 있는지를 확인한다.
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(charArr[i][j] =='*'){
                    // 작은 크기의 십자가를 중심으로, 십자가를 처리할 수 있는지를 행렬 기준으로 모두 확인한다.
                    int maxSize = Math.min(Math.min( i - 0, N - 1 - i), Math.min(j-0, M-1-j));

                    // 가장 작은 크기의 십자가부터 가장 큰 크기의 십자가까지 모두 검사한다.
                    for(int s = 1 ; s <= maxSize; s++){
                        // 각 지점에서의 크기에 맞게 dx,dy를 생성해준다.
                        int[] dx = new int[s * 4];
                        int[] dy = new int[s * 4];

                        int idx = 0;
                        // 행에 대한 값을 dx에 더해준다.
                        for(int k = 1; k <= s; k++){
                            dx[idx] = k;
                            dy[idx] = 0;
                            idx++;

                            dx[idx] = -k;
                            dy[idx] = 0;
                            idx++;
                        }

                        // 열에 대한 값을 dy에 더해준다.
                        for(int k = 1; k <= s; k++){
                            dx[idx] = 0;
                            dy[idx] = k;
                            idx++;

                            dx[idx] = 0;
                            dy[idx] = -k;
                            idx++;
                        }

                        // 모든 지점에 대해서 십자가 모양을 이룰 때, 해당 지점에 대해 값을 빼준다.
                        boolean isCross = true;
                        for(int k = 0; k < s * 4; k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];

                            // 1로 처리된 별을 -1을 해주면 값이 변하기 때문에, charArr을 이용해야 한다.
                            if(nx >= 0 && nx < N && ny >= 0 && ny < M && charArr[nx][ny]=='*'){
//                                if (intArr[nx][ny] != 1){
//                                    isCross = false;
//                                    break;
//                                }

                            }else{
                                isCross = false;
                                break;
                            }
                        }

                        if(isCross){
                            System.out.printf("%d %d %d\n", i, j, s);
                            intArr[i][j] -= 1;
                            for(int k = 0; k < s * 4; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];

                                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                                    intArr[nx][ny] -= 1;
                                }
                            }
                        }


                    }
                }

            }
        }


        /*int[] dx = new int[8];
        int[] dy = new int[8];

        int idx = 0;
        // 행에 대한 값을 dx에 더해준다.
        for(int k = 1; k <= 2; k++){
            dx[idx] = k;
            dy[idx] = 0;
            idx++;

            dx[idx] = -k;
            dy[idx] = 0;
            idx++;
        }

        // 열에 대한 값을 dy에 더해준다.
        for(int k = 1; k <= 2; k++){
            dx[idx] = 0;
            dy[idx] = k;
            idx++;

            dx[idx] = 0;
            dy[idx] = -k;
            idx++;
        }

        System.out.println(Arrays.toString(dx));
        System.out.println(Arrays.toString(dy));*/



        /*int sizeX = 4;
        int sizeY = 4;

        // 4 * 1
        int[] dx = {-1, 1, 0, 0};
        int[] dy = { 0, 0, -1, 1};

        // 4 * 2
        int[] dX = { -1, 1, -2, 2, 0, 0, 0, 0};
        int[] dY = { 0, 0, 0, 0, -1, 1, -2, 2};*/












        // System.out.println(Arrays.deepToString(charArr));
        System.out.println(Arrays.deepToString(intArr));


    }
}
