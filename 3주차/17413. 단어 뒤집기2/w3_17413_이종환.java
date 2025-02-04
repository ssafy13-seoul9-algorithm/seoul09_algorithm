import java.util.Scanner;

class Main
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split("");
		StringBuilder sb = new StringBuilder();
		
		
		
		for (int i = 0; i < input.length; i++) {
			if ( input[i].equals("<")) {
				sb.append(input[i]);
				while(!input[i].equals(">")) {
					sb.append(input[++i]);
				}
			} else if (input[i].equals(" ")) {
				sb.append(" ");
			} else {
				int startIdx = i;
				while( i < input.length && !(input[i].equals(" ") || 
						input[i].equals("<") ) ) {
					i++;
				}
				int endIdx = --i;
				
				
				for (int j = endIdx; j >= startIdx; j--) {
					sb.append(input[j]);
				}
				
			}
		}
		
		System.out.println(sb.toString());
	}
}
