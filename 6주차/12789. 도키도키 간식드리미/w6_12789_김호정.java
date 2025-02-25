import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// 도키도키 간식 드리미
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> student = new LinkedList<>();
        for(int i = 0; i<N; i++){
            int a = sc.nextInt();
            student.add(a);
        }

        Stack<Integer> line = new Stack<>();

        int snack = 1;
        while(!student.isEmpty() || !line.isEmpty()){
            if(!student.isEmpty() && student.peek() == snack){
                student.poll();
                snack ++;
            }else if(!line.isEmpty() &&line.peek() == snack){
                line.pop();
                snack++;
            }
            else if(!student.isEmpty()){
                line.push(student.poll());
            }else{
                System.out.println("Sad");
                return;
            }

        }
        System.out.println("Nice");

    }
}
