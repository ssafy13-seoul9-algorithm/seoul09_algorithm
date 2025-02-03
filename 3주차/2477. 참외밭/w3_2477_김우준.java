import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int K = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[2][6];

        for(int i = 0; i < arr[0].length; i++){
            String[] input = sc.nextLine().split(" ");
            int dir = Integer.parseInt(input[0]);
            int length = Integer.parseInt(input[1]);
            arr[0][i] = length;
            arr[1][i] = dir;
        }

        int[] dir = new int[5];
        for(int i = 0; i < arr[0].length; i++){
            dir[arr[1][i]]++;
        }

        int longXDir = dir[1] > dir[2] ? 2 : 1;
        int longYDir = dir[3] > dir[4] ? 4 : 3;
        int longX = 0;
        int longY = 0;
        for(int i = 0; i < arr[0].length; i++){
            if(arr[1][i] == longXDir){
                longX = arr[0][i];
                continue;
            }
            if(arr[1][i] == longYDir){
                longY = arr[0][i];
                continue;
            }
        }

        int secLong = 0;
        int idx = 0;

        for(int i = 0; i < arr[0].length; i++){
            if(arr[0][i] == longX || arr[0][i] == longY){
                secLong = (arr[0][i] == longX) ? longY : longX;
                break;
            }
        }
        
        for(int i = 0; i < arr[0].length; i++){
            if(arr[0][i] == secLong){
                if(arr[0][(i+1) % 6] == longX || arr[0][(i+1) % 6] == longY){
                    secLong = secLong != longX ? longX : longY;
                    idx += 1;
                }
                idx += i + 2;
                break;
            }
        }
        int wArea = longX * longY;
        int rArea = arr[0][idx % 6] * arr[0][(idx+1) % 6];
        
        System.out.println(K * (wArea - rArea));
    }
}
