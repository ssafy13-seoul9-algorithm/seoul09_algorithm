import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        int cnt = 0;
        int num = -1;
        outer: for(int i = 1; i < arr.length; i++){
            int loc = i - 1;
            int newItem = arr[i];
            
            while ( 0 <= loc && newItem < arr[loc]){
                arr[loc + 1] = arr[loc];
                loc--;
                if (++cnt == k) {
                    num = arr[loc + 1];
                    break outer;
                }
            }
            if(loc + 1 != i) {
                arr[loc + 1] = newItem;
                if (++cnt == k) {
                    num = arr[loc+1];
                    break outer;
                }
            }
        }

        System.out.println(num);
    }
}