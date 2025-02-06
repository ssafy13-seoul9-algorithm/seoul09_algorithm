import java.util.Scanner;

public class w3_1244_김호정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        int[] switches = new int[N+1];

        for(int i=1; i<=N;i++){
            switches[i] = sc.nextInt();
        }

        int stu = sc.nextInt();

        for(int i=0; i<stu; i++){
            int gender = sc.nextInt();
            int num = sc.nextInt();

            // 남자인 경우
            if(gender == 1){
                for(int j=num;j<=N;j+=num){
                    
                    if(switches[j]==0) {
                        switches[j] = 1;
                    }else{
                        switches[j] = 0;
                    }
                }
            }
            
            // 여자인 경우
            else if(gender == 2){
                    
                // 대칭 비교
                int mid = num;
                int distance = 1;

                // 6-0. 대칭 검사를 먼저 수행
                while (mid - distance >= 1 && mid + distance <= N && switches[mid - distance] == switches[mid + distance]) {
                    distance++; 
                }

                // 6-1. 대칭 범위 안의 모든 스위치 변경
                for (int j = mid - (distance - 1); j <= mid + (distance - 1); j++) {
                    if(switches[j]==1) switches[j]=0;
                    else switches[j]=1;
                }
            }
            
        }

        // 20개씩 출력
        for(int i=1;i<=N;i++){
            System.out.print(switches[i]+" ");
            if (i % 20 == 0) {  
                System.out.println();
            }
        }

        
    }
}
