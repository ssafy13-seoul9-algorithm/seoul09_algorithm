import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class w12_1049_김우준 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];

        Set<Integer> pack = new TreeSet<>();
        Set<Integer> single = new TreeSet<>();
        for(int i = 0; i < M; i++){
            input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            pack.add(input[0]);
            single.add(input[1]);
        }

        Iterator<Integer> packIdx = pack.iterator();
        Iterator<Integer> singleIdx = single.iterator();

        int packPrice = packIdx.next();
        int singlePrice = singleIdx.next();

        int packCnt = N / 6;
        int packRemain = N % 6;

        int packMoney = packCnt * packPrice;
        int packSingleMoney = packMoney + packRemain * singlePrice;
        if(packRemain > 0) packMoney += packPrice;
        int singleMoney = N * singlePrice;

        int money = Math.min(singleMoney, Math.min(packMoney, packSingleMoney));

        System.out.println(money);
    }
}
