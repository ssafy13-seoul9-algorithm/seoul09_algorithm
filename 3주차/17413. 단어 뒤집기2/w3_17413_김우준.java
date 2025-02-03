import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("");
        int start = 0;
        int end = 0;
        boolean flag = false;
        boolean rev = true;
        for (int i = 0; i < input.length; i++) {
            if (flag) {
                if (input[i].equals(">")) {
                    flag = false;
                    rev = true;
                }
                continue;
            }

            if (input[i].equals("<")) {
                flag = true;
                continue;
            }

            if (!flag && rev) {
                start = i;
                for (int k = start + 1; k <= input.length; k++) {
                    if (k == input.length || input[k].equals(" ") || input[k].equals("<")) {
                        end = k - 1;
                        break;
                    }
                }
                for (int k = start; k <= start + ((end - start) / 2); k++) {
                    String tmp;
                    tmp = input[k];
                    input[k] = input[end - (k - start)];
                    input[end - (k - start)] = tmp;
                }
                i += end - start;
                rev = false;
                continue;
            }

            if (!flag && input[i].equals(" ")) {
                rev = true;
                continue;
            }
        }

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
    }
}
