import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        // 초기 값 설정
        String result = "Nice";
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> queue = new ArrayList<>();
        int cPoint = 1;
        // 대기 줄 확인
        for(int i = 0; i < N; i++){
            // 현재 위치가 번호와 맞다면
            if(arr[i] == cPoint){
                // 다음 번호로 변경
                cPoint++;
            // 대기열이 있고 마지막 사람이 현재 들어가야 한다면
            } else if (queue.size() != 0 && queue.get(queue.size()-1) == cPoint) {
                // 대기열 제거, 다음 번호로 변경
                queue.remove(queue.size()-1);
                cPoint++;
                // 기존 배열의 위치로 복귀
                i--;
            } else {
                // 다 아니면 대기열에 추가
                queue.add(arr[i]);
            }
        }

        // 남아있는 대기열 확인
        for(int i = queue.size() - 1; i >= 0 ; i--){
            if(queue.get(i) == cPoint){
                cPoint++;
                queue.remove(i);
            } else {
                break;
            }
        }

        // 대기열이 남아 있다면 "Sad" 출력
        if(queue.size() != 0){
            result = "Sad";
        }

        System.out.println(result);

    }
}