
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class w8_1914_이종환 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = sc.nextInt();
		
		
		BigInteger moveCnt = BigInteger.valueOf(2).pow(num).subtract(BigInteger.valueOf(1));
		System.out.println(moveCnt);
		
		if (num > 20) return;

		move(num,1,2,3);
		bw.append(sb.toString());
		bw.flush();
	}
	
	private static void move(int height, int from, int other, int to) {
		if (height == 1) {
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}
		
		move(height-1,from,to,other);
		sb.append(from).append(" ").append(to).append("\n");
		move(height-1,other,from,to);
	}

}
