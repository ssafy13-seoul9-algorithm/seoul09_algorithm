import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class w12_1138_이종환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size =sc.nextInt();
		
		int[] arr = new int[size+1];
		for (int i = 1; i <= size; i++) arr[i] = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		//그냥 뒤부터 넣어주면 끝
		for (int i= size; i >=1; i--) {list.add( arr[i],i);}
		
		for (int i = 0; i < size; i++) System.out.print(list.get(i) + " ");
	}
}
