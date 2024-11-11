import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        String str = Long.toString(n);  // 숫자를 문자열로 변환
        List<Integer> list = new ArrayList<>();
        
        for (int i = str.length() - 1; i >= 0; i--) {
            list.add(str.charAt(i) - '0');
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}