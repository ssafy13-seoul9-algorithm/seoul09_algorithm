import java.util.Scanner;

public class w2_2810_김호정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int ppl = sc.nextInt();
        sc.nextLine();
        
        int cnt = 1; 
        int L_cnt = 0;

        String seats = sc.nextLine(); 

        for (int i = 0; i < ppl; i++) {
            if (seats.charAt(i) == 'S') {
                cnt++;
            } else if (seats.charAt(i) == 'L') {
                cnt++; 
                L_cnt++; 
            }
        }
                
        System.out.println(Math.min(cnt - (L_cnt / 2), ppl));

        sc.close();
    }
}

