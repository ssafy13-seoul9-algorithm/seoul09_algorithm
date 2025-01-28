
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class w2_14696_이종환 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			StringTokenizer aST = new StringTokenizer(br.readLine());
			StringTokenizer bST = new StringTokenizer(br.readLine());
			
			int aCount = Integer.parseInt(aST.nextToken());
			int bCount = Integer.parseInt(bST.nextToken());
			
			int[] aArr = {0,0,0,0};
			int[] bArr = {0,0,0,0};
			
			for (int j = 0; j < aCount; j++) {
				int temp = Integer.parseInt( aST.nextToken());
				aArr[temp -1]++;
			}
			
			for (int j = 0; j < bCount; j++) {
				int temp = Integer.parseInt( bST.nextToken());
				bArr[temp -1]++;
			}
			
			
			for (int j = 3; j >= 0; j--) {
				if ( aArr[j] > bArr[j]) {
					System.out.println("A");
					break;
				} else if (aArr[j] < bArr[j]) {
					System.out.println("B");
					break;
				}
				
				if ( j == 0) {
					System.out.println("D");
				}
			}
		}
		
		
		
	}
} 