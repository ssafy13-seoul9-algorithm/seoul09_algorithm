import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        
        int cnt = 0;
        for(int i=0; i < N; i++){
            String word = sc.nextLine();
            int len = word.length();

            Set<Character> set = new HashSet<>();    
            char prev = ' ';                         

            boolean check = true;

            for(int a = 0; a<len; a++){
                 if(word.charAt(a) != prev){
                    if(set.contains(word.charAt(a))){  
                        check = false;                 
                        break;
                    }
                    set.add(word.charAt(a));             
                
                }
                prev = word.charAt(a);
            }
            if(check == true) cnt++;
        }

        System.out.println(cnt);
        sc.close();
    }
}

