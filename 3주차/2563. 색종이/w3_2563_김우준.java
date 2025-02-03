import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[100][100];
        int area = 0;
        for(int i = 0; i < N; i++){
            String[] input = sc.nextLine().split(" ");
            int startX = Integer.parseInt(input[0]);
            int startY = Integer.parseInt(input[1]);
            for(int y = startY; y < startY + 10; y++){
                for(int x = startX; x < startX + 10; x++){
                    if(arr[y][x] == 0){
                        arr[y][x] = 1;
                        area++;
                    }
                }
            }
        }

        System.out.println(area);
    }
}
