import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static String status = "Invalid";
    static List<String> pos;
    static boolean[][] visited;
    static boolean isValid;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        visited = new boolean[6][6];
        pos = new ArrayList<>();

        for(int i = 0; i < 36; i++){
            String input = sc.nextLine();

            int x = input.charAt(0) - 'A';
            int y = input.charAt(1) - '1';

            if(visited[x][y]){
                isValid = true;
                break;
            }

            visited[x][y] = true;
            pos.add(input);

            if(i > 0 && !check(pos.get(pos.size() - 2))){
                isValid = true;
                break;
            }
        }

        if(!isValid && pos.size() == 36) lastCheck();

        System.out.println(status);
    }

    public static boolean check(String pre){
        String cur = pos.get(pos.size() - 1);
        for(int i = 0; i < 8; i++){
            int nx = cur.charAt(0) - 'A' + dx[i];
            int ny = cur.charAt(1) - '1' + dy[i];
            if(nx == pre.charAt(0) - 'A' && ny == pre.charAt(1) - '1'){
                return true;
            }
        }
        return false;
    }

    public static void lastCheck(){
        if(check(pos.get(0))){
            status = "Valid";
        }
    }
}
