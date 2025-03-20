/* 나이트 이동은 항상 수직2+수평1 OR 수평2+수평1 
 * 입력 받으며 다음 움직임이 아니면 즉시 false
 * "마지막으로 방문하는 칸에서 시작점으로 돌아올 수 있는 경로이다"
 * 어차피 방문할 입력은 전부 들어옴 > 다음 좌표가 규칙 맞는지만 검증하면 ok
 */

 import java.util.*; 

 public class Main {
   
   // 1-4 2칸 1칸 5-8 1칸 2칸
   // 나이트 이동 좌표 확인 
   static int[] dx = {2, -2, 2, -2, 1, -1, 1, -1};
   static int[] dy = {1, 1, -1, -1, 2, 2, -2, -2};
 
   public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     boolean[][] visited = new boolean[6][6]; // 방문한 칸 체크크
     
     // 유효하지 않으면 바로 break
     // 입력은 [A-F][1-6]으로 주어짐 
     int[][] curr = new int[36][2];
 
     for (int i = 0; i < 36; i++){
       // 이동 좌표 
       String next = sc.next();
       int col = next.charAt(0) - 'A';
       int row = next.charAt(1) - '1';
       curr[i][0] = col;
       curr[i][1] = row; 
     } // input 
 
     // 마지막 리턴값 위해 
     boolean flag = true; 
     visited[curr[0][0]][curr[0][1]] = true;
 
 
     // 나이트 이동 & 다음 좌표 받기 & 검증
     for (int i = 0; i < 35; i++){
       boolean validMove = false; // false 지정해놓고 맞으면 true로 돌리기 
 
       int x = curr[i][0];
       int y = curr[i][1];
       int nextX = curr[i+1][0];
       int nextY = curr[i+1][1];
       
       // 이동후보 좌표 계산 
       for (int dir = 0; dir < 8; dir++){
         int moveX = x + dx[dir];
         int moveY = y + dy[dir];
 
         // 돌린 것 중에 다음 좌표 위치 있나?? 
         // 이동 불가능하면 일찌감찌 break
         if (!isValid(moveX, moveY, 6, 6)) continue;
           
         // 하나라도 일치하면 다음으로 넘어가기 
         if (moveX == nextX && moveY == nextY) {
           validMove = true;
           break; // 다음 칸으로 이동하자 
         }
         
       } // dir 탐색 
 
       // 다음 좌표 검증했을 때 틀렸다면 break 
       if (!validMove){
         flag = false;
         break;
       }
 
       // 방문한 적 있으면 invalid
       if (visited[nextX][nextY]){
         flag = false;
         break;
       }
 
       // 방문 체크
       visited[nextX][nextY] = true;
 
       // 마지막 검증 (마지막 좌표 이동했을 때 첫번째로 돌아올 수 있는지?)
       if (i == 34){
         flag = false;
         for (int dir = 0; dir < 8; dir++){
           // 시작점이랑 정말 같니??? 
           if (nextX + dx[dir] == curr[0][0] && nextY + dy[dir] == curr[0][1]){
             flag = true;
             break;
           }
         }
       }
 
     } // 나이트 이동 끝 
 
     // 결과
     String res = flag? "Valid" : "Invalid";
     System.out.println(res);
     
     sc.close();
   }
   
   static boolean isValid(int x, int y, int xN, int yN){
     return (x >= 0 && x < xN && y >= 0 && y < yN);
   }
 }