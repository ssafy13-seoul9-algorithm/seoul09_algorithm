import java.util.Scanner;

public class w2_13300_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int student = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[][] arr = new int[2][7];

        for(int i = 0; i < student; i++){
            input = sc.nextLine().split(" ");
            int sex = Integer.parseInt(input[0]);
            int grade = Integer.parseInt(input[1]);
            arr[sex][grade] += 1;
        }

        int room = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 1; j < 7; j++){
                room += arr[i][j] / K;
                if(arr[i][j] % K > 0){
                    room += 1;
                }
            }
        }
        System.out.println(room);
    }
}
