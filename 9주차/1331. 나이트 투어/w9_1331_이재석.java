import java.util.*;

public class BJ1331 {
	// 체스판을 하나씩 순회할 때, 제대로 체스판을 순회하는지와 모든 칸을 다 제대로 도는지를 확인한다.
	// 마지막으로 방문한 칸에서 시작점으로 돌아올 수 있는지를 확인한다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = 36;
		int M = 6;
		boolean[][] visited = new boolean[M][M];
		for(int i=0; i<M; i++){
			for(int j=0; j<M; j++){
				visited[i][j] = false;
			}
		}

		int[][] intArr = new int[N][2];
		for(int i=0; i<N; i++){
			String str= sc.nextLine();
			char[] temp = str.toCharArray();

			// Alphabet을 일일이 바꾸기 귀찮으니까, ascii 코드상 숫자를 이용한다.
			// 행렬 정보에 맞게 intArr에 넣어준다.
			intArr[i][0] = Integer.parseInt(String.valueOf(temp[1])) - 1;
			intArr[i][1] = temp[0] - 65;

		}

		// System.out.println(intArr[0][0] - 65);

		// System.out.println(Arrays.deepToString(intArr));

		boolean isValid = true;
		int cnt = 0;
		for(int i = 0; i < N; i++){
			// 마지막으로 방문한 칸에서 시작점으로 돌아갈 수 있는지 확인한다.
			if(i==N-1){
				if( (Math.abs(intArr[i][0] - intArr[0][0]) == 1 && Math.abs(intArr[i][1] - intArr[0][1])==2) || (Math.abs(intArr[i][0] - intArr[0][0]) == 2 && Math.abs(intArr[i][1] - intArr[0][1])==1)){
//                    System.out.println(intArr[i][0]);
//                    System.out.println(intArr[i][1]);
//
//                    System.out.println(intArr[0][0]);
//                    System.out.println(intArr[0][1]);
				}else{
					isValid = false;
				}

			}

			// 방문한 곳을 true처리하고, 방문한 곳을 다시 방문한다면 isValue = false 처리 한다.
			if( !visited[intArr[i][0]][intArr[i][1]] ){
				visited[intArr[i][0]][intArr[i][1]] = true;
				cnt++;
			}else{
				isValid = false;
				break;
			}

			// 마지막 체스판이 아닐 때만 나이트가 제대로 움직이는지 확인한다.
			if(i != N-1){
				// 나이트가 제대로 움직이는지 확인한다.
				if( ( Math.abs(intArr[i+1][0] - intArr[i][0]) == 1 && Math.abs(intArr[i+1][1] - intArr[i][1]) ==2) || (Math.abs(intArr[i+1][0] - intArr[i][0]) == 2 && Math.abs(intArr[i+1][1] - intArr[i][1]) ==1)) {
					// System.out.println(true);
					// cnt++;
				}else{
					isValid = false;
					break;
				}
			}

		}

		// System.out.println(cnt);
		// System.out.println(Arrays.deepToString(visited));
		// System.out.println(isValid);
		// System.out.println(cnt);

//        if(cnt != N-1)
//            isValid = false;

		if(isValid){
			System.out.println("Valid");
		}else{
			System.out.println("Invalid");
		}




	}
}
