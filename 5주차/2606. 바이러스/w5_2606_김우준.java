import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pc = Integer.parseInt(sc.nextLine());
        int pair = Integer.parseInt(sc.nextLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < pair; i++){
            String[] input = sc.nextLine().split(" ");
            List<Integer> list = map.getOrDefault(Integer.parseInt(input[0]), new ArrayList<Integer>());
            list.add(Integer.parseInt(input[1]));
            map.put(Integer.parseInt(input[0]), list);

            List<Integer> list2 = map.getOrDefault(Integer.parseInt(input[1]), new ArrayList<Integer>());
            list2.add(Integer.parseInt(input[0]));
            map.put(Integer.parseInt(input[1]), list2);
        }

        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(map.containsKey(current)){
                for(int n : map.get(current)){
                    if(!set.contains(n)){
                        set.add(n);
                        queue.offer(n);
                    }
                }
            }
        }

        System.out.println(set.size() > 0 ? set.size() - 1 : 0);
    }
}
