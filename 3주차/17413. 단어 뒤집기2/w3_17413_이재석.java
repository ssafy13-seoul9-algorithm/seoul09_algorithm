import java.util.*;

public class BJ17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] stringInput = input.split("");
        int len = stringInput.length;

        Stack<String> s = new Stack<>();

        int idx =0;
        // len-1이 되면 탈출하도록 while문을 돈다.
        while(idx<len-1){
            //괄호로 시작하는 부분이 있다면 괄호가 끝날때까지 그대로 출력한다.
            if(stringInput[idx].equals("<")){
                while(stringInput[idx].equals("<")) {
                    boolean open = true;
                    // 괄호가 열릴 때 순서, 해당 문자열을 순서 그대로 출력한다.
                    while (open) {
                        System.out.printf(stringInput[idx]);
                        idx++;
                        if (stringInput[idx].equals(">")) {
                            open = false;
                            System.out.printf(stringInput[idx]);
                            if (idx == len - 1) {
                                break;
                            }
                            idx++;

                        }

                    }
                }
            }
            // 괄호가 아닌 부분으로 시작한다면, 스택에 쌓고 거꾸로 출력해준다.
            else{
                while(!stringInput[idx].equals("<")){
                    // 꺾쇠나 공백 기준으로 스택에 push 하고 빌 때까지 pop을 해야 한다.
                    while(!stringInput[idx].equals(" ") && !stringInput[idx].equals("<")){
                        s.push(stringInput[idx]);
                        if (idx== len-1){
                            break;
                        }
                        idx++;
                    }

                    while(!s.isEmpty()){
                        System.out.printf(s.pop());
                    }

                    if (idx== len-1){
                        break;
                    }

                    if(stringInput[idx].equals(" ")){
                        // 공백에서 걸리지 않게 idx++으로 업데이트 해준다.
                        System.out.print(" ");
                        idx++;
                    }

                }


            }
        }




//        while(stringInput[idx].equals("<")){
//            boolean open = true;
//            // 괄호가 열릴 때 순서, 해당 문자열을 순서 그대로 출력한다.
//            while(open){
//                System.out.printf(stringInput[idx]);
//                idx++;
//                if(stringInput[idx].equals(">")){
//                    open = false;
//                    System.out.printf(stringInput[idx]);
//                    if (idx== len-1){
//                        break;
//                    }
//                    idx++;
//
//                };
//            }
//
//            if (idx== len-1){
//                break;
//            }
//
//            // 괄호가 아닌 부분은 스택에 쌓고, 거꾸로 출력해준다.
//            while(!stringInput[idx].equals("<")){
//                s.push(stringInput[idx]);
//                if (idx== len-1){
//                    break;
//                }
//                idx++;
//            }
//            while(!s.isEmpty()){
//                System.out.printf(s.pop());
//            }
//
//
//
//        }

        //System.out.println(Arrays.deepToString(stringInput));

    }
}
