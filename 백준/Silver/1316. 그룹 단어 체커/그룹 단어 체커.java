import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         int n = Integer.parseInt(br.readLine());
         int count = 0;
         
         for (int i = 0; i < n; i++) {
             boolean check = true;
             boolean [] arr = new boolean[26];
             int prev = 0;  // 이전 문자
             String str = br.readLine();
             for (int j = 0; j < str.length(); j++) {
                 int now = str.charAt(j);  // 문자열 중 j번째 문자의 아스키코드
                 if (prev != now) {  // 이전 문자와 현재 문자가 다르면?
                     if(!arr[now - 'a']) {  // 현재 문자가 처음 등장하면?
                         arr[now - 'a'] = true;  // 등장으로 처리
                         prev = now;  // 이전 문자를 현재 문자로 수정
                     } else check = false;
                 } else continue;
             }
             if (check) count++;
         }
         System.out.println(count);
    }
}