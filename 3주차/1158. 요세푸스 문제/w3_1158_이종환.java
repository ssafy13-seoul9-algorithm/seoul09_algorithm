
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;


class Main
{
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in); 
		
		int size = sc.nextInt();
		int index = sc.nextInt() - 1;
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= size; i++) {
			q.add(i);
		}
		
		Queue<String> ans = new LinkedList<>();
		
		for (int i = 1; i <= size; i++) {
			for (int j = 0; j < index; j++) {
				q.add(q.poll());
			}
			ans.add(q.poll().toString());
		}
		
		
		
		System.out.print("<");
		System.out.print(ans.stream().collect(Collectors.joining(", ")));
		System.out.println(">");
		
		
		
	}
}
