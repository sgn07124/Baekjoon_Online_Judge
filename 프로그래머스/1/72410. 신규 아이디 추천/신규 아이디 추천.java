import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder(new_id);
        
        // 1단계: new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isUpperCase(c)) sb.setCharAt(i, Character.toLowerCase(c));
        }
        
        // 2단계: new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                continue;
            }
            sb.deleteCharAt(i);
        }
        
        // 3단계: new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        sb = new StringBuilder(sb.toString().replaceAll("[.]{2,}", "."));
        
        // 4
        if (sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        
        // 5
        if (sb.length() == 0) sb.append('a');
        
        // 6
        if (sb.length() >= 16) sb.setLength(15);
        while (sb.charAt(sb.length() - 1) == '.') sb.setLength(sb.length() - 1);
        
        // 7
        if (sb.length() <= 2) {
            char c = sb.charAt(sb.length() - 1);
            while (sb.length() < 3) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}