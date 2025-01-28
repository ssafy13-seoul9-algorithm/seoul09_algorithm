import java.util.*;

public class BJ8958 {
    public static void main(String[] args) {
        //OOXXOXXOOO

        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();

        for (int i=0; i<testcase; i++){
            String input = sc.nextLine();
            String[] stringInput = input.split("");

            int score = 0;
            int streak = 0;
            for(int j=0; j<stringInput.length; j++){
                if (stringInput[j].equals("O")){
                    streak+=1;
                }else{
                    streak=0;
                }
                score +=streak;
            }

            System.out.println(score);
        }

    }
}
