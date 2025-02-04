import java.util.Scanner;


class Main
{
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int ans = 0;

	
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		String[] cro = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		int len = 0;
		
		for (int i = 0 ; i< input.length(); i++) {
			len++;
			for (int j = 0; j < cro.length; j++) {
				boolean isSame = true;
				
				for (int k = 0; k < cro[j].length(); k++) {
					if ( i + k >= input.length() || (input.charAt(i+k) != cro[j].charAt(k))){
						isSame = false;
						break;
					}
				}
				if (isSame) {
					i+= cro[j].length()-1;
					break;
				}
				
			}
		}
		
		System.out.println(len);
		
	}
}