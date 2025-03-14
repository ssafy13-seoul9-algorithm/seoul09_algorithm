import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class w9_1331_이종환 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[][] visited = new boolean[6][6];
		int[][] position = new int[36][2];
		
		String rawInput = br.readLine();
		//char를 아스키 코드를 통해 변환
		position[0][0] = rawInput.charAt(0)-65; 
		position[0][1]= rawInput.charAt(1)-49; 
		visited[position[0][0]][position[0][1]] = true;
		
		boolean isValid = true;
		
		for (int i = 1; i < 36; i++) {

			rawInput = br.readLine();
			if (!isValid) continue;
			
			//char를 아스키 코드를 통해 변환
			int alphabet = position[i][0] = rawInput.charAt(0)-65; 
			int num = position[i][1] =  rawInput.charAt(1)-49; 
			int preAlphabet = position[i-1][0];
			int preNum = position[i-1][1];
			
			int alphabetDiff = Math.abs(preAlphabet - alphabet);
			int numDiff = Math.abs(preNum - num);
			
			if (((alphabetDiff== 1 && numDiff == 2) ||(alphabetDiff== 2 && numDiff == 1))
					&& !visited[alphabet][num]) {
				visited[alphabet][num] = true;
			} else {
				isValid = false;
			}
			
			preAlphabet = alphabet;
			preNum = num;
		}
		
		// 마지막 위치에서 처음위치 갈 수 있는 지 확인
		int alphabetDiff = Math.abs(position[35][0] - position[0][0]);
		int numDiff = Math.abs(position[35][1] - position[0][1]);
		
		if ( isValid && ((alphabetDiff== 1 && numDiff == 2) ||(alphabetDiff== 2 && numDiff == 1))){
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
	}
}
