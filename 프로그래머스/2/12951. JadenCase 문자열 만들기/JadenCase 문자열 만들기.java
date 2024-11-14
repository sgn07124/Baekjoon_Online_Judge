import java.util.*;
class Solution {
    public String solution(String s) {
        // 소문자 치환
        s = s.toLowerCase();
        // 스트링버퍼
        StringBuffer sb = new StringBuffer();
        // 문자열 길이만큼 반복
        for(int i=0;i<s.length();i++){
            // 현재 문자
            String c = String.valueOf(s.charAt(i));
            // 첫번째 문자면
            if(i==0){
               c = c.toUpperCase();
            }
            // 바로앞 문자가 공백(' ')이면
            else if(s.charAt(i-1)==' '){
                c = c.toUpperCase();
            }
            // 스트링버퍼 추가
            sb.append(c);
        }
        // 문자열 변환
        return sb.toString();
    }
}