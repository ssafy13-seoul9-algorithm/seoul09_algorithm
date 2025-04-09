import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class w12_3213_이종환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int friendCnt = Integer.parseInt(br.readLine());
		int oneFourth,oneSecond,threeFourth,pizzaCnt;
		oneFourth = oneSecond = threeFourth = pizzaCnt = 0;

		for (int i = 0; i < friendCnt; i++) {
			String fraction = br.readLine();
			switch (fraction) {
			case "1/2": oneSecond++;break;
			case "1/4": oneFourth++;break;
			case "3/4": threeFourth++;break;
			}
		}
		
		pizzaCnt += oneSecond/2;
		oneSecond %= 2;
		
		if (threeFourth != 0) {
			pizzaCnt += threeFourth;
			oneFourth = Math.max(0, oneFourth-threeFourth);
		}
		
		if (oneSecond != 0) {
			pizzaCnt += oneSecond;
			oneFourth = Math.max(0, oneFourth-2);
		}
		
		pizzaCnt += (oneFourth%4 == 0)?oneFourth/4: oneFourth/4+1;

		System.out.println(pizzaCnt);
	}
}
