import java.util.*;

class Solution {
    public String solution(String s) {
        
        int length = s.length();
        String answer = "";
        
        // 문자열 길이가 홀수인 경우
        if (length % 2 == 1) {
            int midIndex = length / 2;
            answer = String.valueOf(s.charAt(midIndex));
        } 
        // 문자열 길이가 짝수인 경우
        else {
            int midIndex1 = length / 2 - 1;
            int midIndex2 = length / 2;
            answer = s.substring(midIndex1, midIndex2 + 1);
        }
        
        return answer;
    }
}