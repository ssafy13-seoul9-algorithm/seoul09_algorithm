import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] input = sc.nextLine().split(" ");

        Map<Integer, Boolean> nMap = new HashMap<>();
        for(String n : input){
            nMap.put(Integer.parseInt(n), true);
        }

        int M = Integer.parseInt(sc.nextLine());
        input = sc.nextLine().split(" ");

        for(String n : input){
            System.out.print(nMap.containsKey(Integer.parseInt(n)) ? "1 " : "0 ");
        }
    }
}