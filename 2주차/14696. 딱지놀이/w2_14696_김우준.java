import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        
        for(int i = 0; i < N; i++){
            int[][] arr = new int[2][5];
            for(int p = 0; p < 2; p++){
                String[] input = sc.nextLine().split(" ");
                for(int card = 1; card < input.length; card++){
                    arr[p][Integer.parseInt(input[card])] += 1;
                }
            }
            boolean flag = true;
            for(int card = 4; card > 0; card--){
                if(arr[0][card] > arr[1][card]){
                    System.out.println("A");
                    flag = false;
                    break;
                } else if(arr[0][card] < arr[1][card]){
                    System.out.println("B");
                    flag = false;
                    break;
                }
            }  
            if(flag){
                System.out.println("D");
            }
        }
    }
}
