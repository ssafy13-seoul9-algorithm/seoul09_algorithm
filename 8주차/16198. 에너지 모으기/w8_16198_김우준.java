import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    static List<Integer> list;
    static int max;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        list = new ArrayList<>(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));

        calc(0, 0);

        System.out.println(max);
    }

    public static void calc(int idx, int energy){
        if(list.size() == 2){
            max = Math.max(max, energy);
            return;
        }

        for(int i = 1; i < list.size() - 1; i++){
            int gain = list.get(i-1) * list.get(i+1);
            int num = list.remove(i);
            calc(i + 1, energy + gain);
            list.add(i, num);
        }
    }
}
