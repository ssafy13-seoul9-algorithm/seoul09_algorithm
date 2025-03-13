// BackTracking을 통해서 뽑은 구슬을 배열에 다시 되돌려 놓음으로써,
// 코드의 간결성과 정리된 풀이를 작성 가능
import java.util.*;

public class BJ16198_New {
    static int max = -1;
    static ArrayList<Integer> arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        arr = new ArrayList<>();
        for(int i=0; i<N; i++){
            arr.add(sc.nextInt());
        }

        // System.out.println(arr);

        calcEnergy(arr, 0);
        System.out.println(max);

    }

    static void calcEnergy(ArrayList<Integer> arr, int energy){
        // 공이 2개 남아 있을 경우, 최대값을 갱신하고 재귀함수를 탈출한다.
        if(arr.size()==2){
            max = Math.max(max, energy);
            return;
        }

        // 첫번째랑 마지막 공을 제외하고 뽑은 뒤, 앞 뒤 공의 에너지 수준을 구한다.
        // 해당 과정을 모든 공의 순열에 대해서 반복해준다.
        for(int i=1; i < arr.size()-1; i++){
            int gain = arr.get(i-1) * arr.get(i+1);
            int removedBall = arr.remove(i);

            // 해당 과정을 1번째에서 배열 끝까지 반복해준다.
            calcEnergy(arr, energy+ gain);

            // 빼놨던 공을 다시 원래대로 되돌려주고,
            arr.add(i, removedBall);

        }

    }



}

// 순열을 이용하다 망한 풀이
// arr 및 pick 인덱스를 고려하는 과정에서 숫자가 꼬임
import java.util.*;

public class BJ16198 {
    // N개의 에너지 구슬이 일렬로 놓아져 있고, 에너지를 모으려고 한다.
    // 첫번째와 마지막 구슬이 아닌 것을 고른다.
    // 고른 x번째 구슬을 제거한다.
    // W(x-1) * W(x+1)의 에너지를 모은다.
    // 에너지 구슬을 다시 1~N번까지 번호를 매긴다.

    // 그러니까 재귀함수의 Base Case는 2개의 원소가 남을 때이다.


    // 아무튼 뽑히는 순서에 따라서 계산 값이 바뀔 수 있으니, 순열로 생각해야 해
    // 2 1 3
    // 1 3 2
    // 3 2 1

    static int N, pickLen;
    static ArrayList<Integer> arr, pick;

    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        pickLen = N-2;
        arr = new ArrayList<>();
        pick = new ArrayList<>();

        for(int i=0; i < N; i++){
            arr.add(sc.nextInt());
        }


        //System.out.println(N);
        //System.out.println(arr);

        // nums = new int[]{0, 1, 2, 3};
        // N = nums.length;

        // 재귀 중간에 배열을 반환하기는 빡세니까, 그냥 pickIdx를 이용해서 관리하는 방법이 편할듯.
        perm(1);
        int result = -1;
        int arrLen = arr.size();
        ArrayList<Integer> tempArr = new ArrayList<>(arr);
        for(int l=0; l<arrLen/pickLen; l++){
            int energy = 0;
            int adjIdx = 0;
            ArrayList<Integer> curArr = new ArrayList<>(arr);
            for(int i=l*pickLen ; i < (l+1) * pickLen;i++){
                // 인덱스 기반 -1번째, +1번째 항목을 곱하고 energy에 더한다.
                // 해당 항목을 없애는데 줄어든 항목 개수를 반영해서 adjIdx를 만들어준다.
                int idx = pick.get(i) - 1 - adjIdx;
                System.out.println(idx);
                // System.out.println(adjIdx);
                if(idx <=0 || idx>=curArr.size()-1)
                    continue;
                energy += curArr.get( idx - 1 ) * curArr.get(idx + 1 );

                //System.out.printf("%d %d\n", arr.get( pick.get(i)-1 - adjIdx -1 ), arr.get(pick.get(i) - 1 - adjIdx +1));
                //System.out.println(energy);

                // 내가 제거한 숫자가 고른 숫자보다 더 작을 때만, adjIdx+=1을 해준다.
                if(curArr.get(pick.get(i)) < pick.get(i))
                    adjIdx +=1;

                curArr.remove(pick.get(i));

                System.out.println(curArr);

                System.out.println(pick);
                if(result < energy){
                    result = energy;
                }
            }
        }


        System.out.println(result);


    }

    // 어차피 뽑히는 순서에 따라서 계산 값이 바뀔테니까 뽑히는 순서에 대한 배열을 뽑아내고,
    // 그 배열에서 앞*뒤의 시그마를 조지면 답이 나올 것ㅋ
    // 배열에서 가장 첫번째 요소랑 마지막 요소를 제외하고 순열을 돌리면 된다.
    public static void perm(int idx){
        // Base case
        if(idx == N-1){
            // System.out.println(arr);

            for(int i=0; i < arr.size(); i++){
                if(i != 0 && i != arr.size()-1){
                    pick.add(arr.get(i));
                }
            }
            // System.out.println(pick);

            return;
        }

        // Recursive Case
        // idx 번째와 i 번째 항목을 바꿔준다.
        // 배열의 끝까지 i, idx(i+1) 번째 항목을 바꿔준다.
        // 원래대로 배열을 다시 되돌려주면서, 그 다음 i, idx 번째 항목을 바꿔준다.
        for(int i = idx; i < N-1; i++){
            swap(i, idx);
            perm(idx+1);
            swap(i, idx);
        }

    }

    // 순열의 순서를 바꿔준다.
    static void swap(int a, int b){
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }







}
