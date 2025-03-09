
import java.io.IOException;
import java.util.Scanner;

public class w8_17478_이종환 {
	static final String INTRO = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
	static final String QUESTION = "\"재귀함수가 뭔가요?\"\n";
	static final String ANSWER1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\r\n";
	static final String ANSWER2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	static final String ANSWER3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	static final String FINALANSWER =  "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	static final String END = "라고 답변하였지.\n";
	static final String LINE = "____";
	static int goal;
	static StringBuilder sb ;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		sb =new StringBuilder();
		
		goal = sc.nextInt();
		sb.append(INTRO);
		recursion(0);
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
	
	static void recursion(int cnt) throws IOException {
		sb.append(LINE.repeat(cnt)).append(QUESTION);
		
		if (cnt == goal) {
			sb.append(LINE.repeat(cnt)).append(FINALANSWER);
			sb.append(LINE.repeat(cnt)).append(END);
			return;
		}
		
		sb.append(LINE.repeat(cnt)).append(ANSWER1);
		sb.append(LINE.repeat(cnt)).append(ANSWER2);
		sb.append(LINE.repeat(cnt)).append(ANSWER3);
		recursion(cnt+1);
		sb.append(LINE.repeat(cnt)).append(END);
	}
}
