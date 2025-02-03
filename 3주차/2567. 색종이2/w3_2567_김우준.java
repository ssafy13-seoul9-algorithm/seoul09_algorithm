import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean[][] arr = new boolean[102][102];
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        int peri = 0;
        for(int t = 0; t < cnt; t++){
            String[] input = sc.nextLine().split(" ");
            int startX = Integer.parseInt(input[0]);
            int startY = Integer.parseInt(input[1]);

            for(int i = startX + 1; i <= startX + 10; i++){
                for(int j = startY + 1; j <= startY + 10; j++){
                    arr[i][j] = true;
                }
            }
        }

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        for(int i = 1; i < 101; i++){
            for(int j = 1; j < 101; j++){
                if(arr[i][j]){
                    int condition = 0;
                    for(int k = 0; k < dx.length; k++){
                        if(!(arr[i+dx[k]][j+dy[k]])){
                            condition++;
                        }
                    }
                    if(condition == 2){
                        peri += 2;
                    } else if (condition == 1){
                        peri += 1;
                    }
                }
            }
        }

        System.out.println(peri);
    }
}