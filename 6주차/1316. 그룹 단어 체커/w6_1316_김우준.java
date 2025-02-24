import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int cnt = 0;
        for(int i = 0; i < N; i++){
            // 단어 배열로 입력 받음
            char[] input = sc.nextLine().toCharArray();
            // 확인용 배열 선언
            int[] arr = new int['z'-'a'+1];
            // 중복 확인용 플래그 선언
            boolean flag = true;
            for(int j = 0; j < input.length - 1; j++){
                // 현재 문자와 다음 문자가 다르다면
                if(input[j] != input[j+1]){
                    // 이미 등장했던 문자라면
                    if(arr[input[j]-'a'] != 0){
                        // 중복 플래그 비활성 후 반복 종료
                        flag = false;
                        break;
                    } else {
                        // 문자 등장 여부 설정
                        arr[input[j]-'a']++;
                    }
                }
            }
            // 플래그가 활성화 상태라면
            if(flag){
                // 마지막 문자 등장 여부 확인
                if(arr[input[input.length-1]-'a'] != 0) continue;
                // 개수 +1
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}