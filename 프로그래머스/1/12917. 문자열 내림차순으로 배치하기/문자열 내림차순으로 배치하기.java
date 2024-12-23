import java.util.*;
class Solution {
    public static String solution(String s) {
        String answer = "";

        String [] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());

        for (String a : str) {
            answer += a;
        }
        return answer;
    }
}