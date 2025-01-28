import java.util.Scanner;

public class w2_8958_김호정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		sc.nextLine();


		for(int i= 0;i<a;i++){
			int sum = 0;  // 최종 점수 저장
			int cnti = 0; //연속된 수 저장
			
			String num = sc.nextLine();

			for(int j=0;j<num.length();j++){
				if(num.charAt(j)=='O'){
					cnti++;
					sum+=cnti;
				}else{
					cnti=0;
				}
			}
			System.out.println(sum);

			
		}
		
	}

}