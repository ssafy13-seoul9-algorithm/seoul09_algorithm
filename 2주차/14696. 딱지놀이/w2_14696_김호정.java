import java.util.Scanner;

public class w2_14696_김호정 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt(); // 총 라운드 수

        for(int round=0;round<N;round++){
            int A_star = 0, A_circle = 0, A_rectangle = 0, A_triangle = 0;
            int A = sc.nextInt();
            for (int i = 0; i < A; i++) {
                int shape = sc.nextInt();
                if (shape == 4) A_star++;
                else if (shape == 3) A_circle++;
                else if (shape == 2) A_rectangle++;
                else if (shape == 1) A_triangle++;
            }

            int B_star = 0, B_circle = 0, B_rectangle = 0, B_triangle = 0;
            int B = sc.nextInt();
            for (int i = 0; i < B; i++) {
                int shape = sc.nextInt();
                if (shape == 4) B_star++;
                else if (shape == 3) B_circle++;
                else if (shape == 2) B_rectangle++;
                else if (shape == 1) B_triangle++;
            }

            // 별 -> 동글 -> 네모 -> 세모
            if(A_star>B_star){
                System.out.println("A");
            } else if (A_star < B_star) {
                System.out.println("B");
            }else{
                if(A_circle>B_circle){
                    System.out.println("A");
                }else if(A_circle<B_circle){
                    System.out.println("B");
                }else{
                    if(A_rectangle>B_rectangle){
                        System.out.println("A");
                    }else if(A_rectangle<B_rectangle){
                        System.out.println("B");
                    }else{
                        if(A_triangle>B_triangle){
                            System.out.println("A");
                        }else if(A_triangle<B_triangle){
                            System.out.println("B");
                        }
                        else System.out.println("D");
                    }
                }

            }
        }
        sc.close();
    }
}
