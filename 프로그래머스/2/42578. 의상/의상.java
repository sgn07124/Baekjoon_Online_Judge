import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        int len = clothes.length;
        Map<String, Integer> matches = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            String type = clothes[i][1];
            // 조합만 확인하면 되므로 의상 종류에 대한 개수만 저장한다.
            matches.put(type, matches.getOrDefault(type, 0) + 1);
        }
        
        for (String key : matches.keySet()) {
            answer *= matches.get(key) + 1;
        }
        
        return answer - 1;
    }
}