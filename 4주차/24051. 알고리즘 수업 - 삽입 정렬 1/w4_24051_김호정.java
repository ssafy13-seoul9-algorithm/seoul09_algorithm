import java.util.Scanner;

public class w4_24051_김호정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int cnt = 0;

        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]  = sc.nextInt();
        }

        for(int i=1;i<N;i++){
            int temp = arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[j]>temp){
                    arr[j+1] = arr[j]; 
                    cnt++;
                    if (cnt == K) {
                        System.out.printf("%d",arr[j+1]);
                        return;
                    }

                }else{
                    break;
                }
            }
            for(int j=i-1;j>=0;j--){
                if (j + 1 != i) {
                    arr[j + 1] = temp; 
                    cnt++;
                    if (cnt == K) {
                        System.out.printf("%d", arr[j + 1]);
                        return;
                    }
                }
            }
        }
        System.out.println("-1");

    }
}
