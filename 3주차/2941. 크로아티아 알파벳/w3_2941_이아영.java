import java.util.Scanner;

public class w3_2941_이아영 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		int cnt = st.length();
		for (int i = 1; i < st.length() ; i++) {
			// -의 경우 
			if (st.charAt(i) == '-') {
				if ((st.charAt(i-1) == 'c') || (st.charAt(i-1) == 'd')) {
					cnt--;
				}
				
			// =의 경우 
			} else if (st.charAt(i) == '=') {
				if ((st.charAt(i-1) == 'c') || st.charAt(i-1) == 's') {
					cnt--;
				}
				// z인 경우 -> 앞에 z가 끝이냐 dz냐에 따라 결과 달라
				else if (st.charAt(i-1) == 'z') {
					if ((i - 2 >= 0) && (st.charAt(i-2) == 'd')) {
						cnt -= 2;
					} else {
						cnt--;
					}
				}
			// j의 경우 
			} else if (st.charAt(i) == 'j') {
				if ((st.charAt(i-1) == 'l') || (st.charAt(i-1) == 'n')) {
					cnt--;
				}
				
			}

		sc.close();
		}	
		System.out.println(cnt);

	}
}