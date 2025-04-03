import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class w11_11586_김우준 {
    static int[] list;
    static int[] idxList;
    static int idx;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        // LIS용 배열
        list = new int[N+1];
        // LIS 인덱스 저장용 배열
        idxList = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 초기 인덱스
        idx = 0;
        // LIS 최소값 설정
        list[0] = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            // 만약 현재 LIS 인덱스 위치에서 i번째 수가 더 크다면
            if(list[idx] < arr[i]){
                // LIS인덱스를 증가시킨 후 위치에 해당 값을 할당
                list[++idx] = arr[i];
                // LIS인덱스 보존 배열에 현재 인덱스 저장
                idxList[i] = idx;
            } else {
                // 작다면 Left Bound인덱스 확인 후 해당 인덱스 위치에 값 갱신
                // 해당 위치 인덱스 저장
                idxList[i] = check(arr[i]);
            }
        }
        

        // 인덱스 배열의 뒷 부분부터 현재 인덱스에 해당하는 값과 일치한 경우,
        // 일치하는 "인덱스 배열"의 인덱스로 원본 수열의 값 추적
        int idxRev = idx;
        // LIS 복원 배열
        int[] lis = new int[idx+1];
        
        System.out.println(idx);
        StringBuilder sb = new StringBuilder();
        for(int i = N; i >= 0; i--){
            if(idxList[i] == idxRev){
                lis[idxRev] = arr[i];
                idxRev--;
            }
        }

        for(int i = 1; i <= idx; i++){
            sb.append(lis[i]);
            if(i != idx) sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    static int check(int num){
        int lv = 0;
        int rv = idx;

        while(lv < rv){
            int mid = (lv + rv) / 2;
            if(num > list[mid]){
                lv = mid + 1;
            } else {
                rv = mid;
            }
        }
        list[lv] = num;
        return lv;
    }
}