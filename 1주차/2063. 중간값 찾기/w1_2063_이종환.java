import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class w1_2063_이종환 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		
		int cnt = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < cnt; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		list.sort(Comparator.naturalOrder());
		
		System.out.print(list.get(cnt/2));
	}
}
