import java.util.*;

public class BJ2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1.c=, 2.c-, 3.dz=, 4.d-, 5.lj, 6.nj, 7.s=, 8.z=
        String input = sc.nextLine();
        String[] stringInput = input.split("");
        int totCount =0;
        int idx = 0;
        while(idx<stringInput.length){
            StringBuilder sb = new StringBuilder();

            if(stringInput[idx].equals("c")){
                sb.append(stringInput[idx]);
                sb.append(stringInput[idx+1]);
                String tempString = sb.toString();
                if(tempString.equals("c=")){
                    totCount+=1;
                    idx+=2;
                }else if(tempString.equals("c-")){
                    totCount+=1;
                    idx+=2;
                }else{
                    totCount+=1;
                    idx+=1;
                }
            }else if(stringInput[idx].equals("d")){
                sb.append(stringInput[idx]);
                sb.append(stringInput[idx+1]);
                String tempString = sb.toString();
                if(tempString.equals("d-")){
                    totCount+=1;
                    idx+=2;
                }else{
                    sb.append(stringInput[idx+2]);
                    String addTempString = sb.toString();
                    if(addTempString.equals("dz=")){
                        totCount+=1;
                        idx+=3;
                    }else{
                        totCount+=1;
                        idx+=1;
                    }
                }

            }else if(stringInput[idx].equals("l")){
                sb.append(stringInput[idx]);
                sb.append(stringInput[idx+1]);
                String tempString = sb.toString();
                if(tempString.equals("lj")){
                    totCount+=1;
                    idx+=2;
                }else{
                    totCount+=1;
                    idx+=1;
                }
            }else if(stringInput[idx].equals("n")){
                sb.append(stringInput[idx]);
                sb.append(stringInput[idx+1]);
                String tempString = sb.toString();
                if(tempString.equals("nj")){
                    totCount+=1;
                    idx+=2;
                }else{
                    totCount+=1;
                    idx+=1;
                }
            }else if(stringInput[idx].equals("s")){
                sb.append(stringInput[idx]);
                sb.append(stringInput[idx+1]);
                String tempString = sb.toString();
                if(tempString.equals("s=")){
                    totCount+=1;
                    idx+=2;
                }else{
                    totCount+=1;
                    idx+=1;
                }
            }else if(stringInput[idx].equals("z")){
                sb.append(stringInput[idx]);
                sb.append(stringInput[idx+1]);
                String tempString = sb.toString();
                if(tempString.equals("z=")){
                    totCount+=1;
                    idx+=2;
                }else{
                    totCount+=1;
                    idx+=1;
                }
            }else{
                totCount+=1;
                idx+=1;
            }
        }

        System.out.println(totCount);


    }
}
