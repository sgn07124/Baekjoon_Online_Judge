import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         int n = Integer.parseInt(br.readLine());  // 회의실 시간
         int [][] time = new int [n][2];  // 회의 시간 배열
         
         for (int i = 0; i < n; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine());
             time[i][0] = Integer.parseInt(st.nextToken());  // 시작 시간
             time[i][1] = Integer.parseInt(st.nextToken());  // 종료 시간
         }
         
         Arrays.sort(time, (a, b) -> {
             if (a[1] == b[1]) {  // 종료 시점이 같으면 시작 지점을 기준으로 오름차순
                 return a[0] - b[0];
             } else {  // 종료 시점이 다르면 종료가 빠른 기준으로 오름차순 
                 return a[1] - b[1];
             }
         });
         
         int result = 0;
         int endTime = 0;
         
         for (int [] t : time) {
             if (t[0] >= endTime) {
                 endTime = t[1];
                 result++;
             }
         }
         
         System.out.println(result);
    }
}