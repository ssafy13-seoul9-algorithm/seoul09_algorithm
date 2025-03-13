package 백트래킹;

import java.util.ArrayList;
import java.util.Scanner;

public class w8_16198_김호정 {

    static int N;                   // 배열 크기
    static ArrayList<Integer> arr; // 숫자 입력된 배열 (ArrayList로 선택한 이유는 내 지우는 수의 양옆을 골라서 곱해야 되니까 그냥 배열보다 arraylist가 편하게 구현할 수 있을 것 같았음)

    static int maxSum = 0;     // 정답 저장해줄 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());
        }

        energy(arr, maxSum);
    }

    static void energy(ArrayList<Integer> list, int sum) {
        // 종료 조건
        if (list.size() == 2) { // 구슬이 두 개만 남으면 
            maxSum = Math.max(sum, maxSum); // 최대값을 찾아서 maxSum에 저장
        }

        // 지울 수를 맨 처음과 맨 끝을 뺀 범위로 지정
        for (int i = 1; i < arr.size() - 1; i++) {
            int energySum = list.get(i - 1) * list.get(i + 1);

            // 이 부분에 대해서 생각이 안 나서 지피티 찾아봄
            // 어떻게 하나씩 값 지우면서 재귀 호출할 수 있는지
            ArrayList<Integer> list2 = new ArrayList<>(list);
            list2.remove(i);

            // 새롭게 복사해서 값 하나 지운 arraylist와 누적합에 현재 나온 새로운 값 더해서 재귀 다시 호출
            energy(list2, sum + energySum);
        }
    }
}
