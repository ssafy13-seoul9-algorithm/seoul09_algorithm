import java.util.Scanner;

public class w3_2941_김호정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();

        int i = 0;
        int cnt = 0;
        
        while(i<a.length()){
            if(i + 1 < a.length() && (a.charAt(i) == 'c' || a.charAt(i) == 's' || a.charAt(i) == 'z') && a.charAt(i + 1) == '=') i++;
            if(i+2<a.length() && a.charAt(i) == 'd' && a.charAt(i + 1) == 'z' && a.charAt(i + 2) == '=') i+=2;
            if(i+1<a.length() && (a.charAt(i)=='c'||a.charAt(i)=='d') && a.charAt(i+1)=='-') i++;
            if(i+1<a.length() && (a.charAt(i)=='l'||a.charAt(i)=='n') && a.charAt(i+1)=='j') i++;
            cnt++;
            i++;
            
        }
        System.out.println(cnt);
    }
    
}