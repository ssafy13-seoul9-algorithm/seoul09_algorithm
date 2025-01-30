import java.util.Scanner;

public class w2_3985_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        int people = Integer.parseInt(sc.nextLine());

        int[] cake = new int[length + 1];
        int rMax = 0;
        int eMax = 0;
        int rPerson = 0;
        int ePerson = 0;
        for(int i = 1; i <= people; i++){
            String[] input = sc.nextLine().split(" ");
            int rCnt = 0;
            int eCnt = 0;
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            for(int j = start; j <= end; j++){
                if(cake[j] == 0){
                    cake[j] = i;
                    rCnt++;
                }
                eCnt++;
            }
            if(rCnt > rMax){
                rMax = rCnt;
                rPerson = i;
            }
            if(eCnt > eMax){
                eMax = eCnt;
                ePerson = i;
            }
        }
        System.out.println(ePerson);
        System.out.println(rPerson);
    }
}