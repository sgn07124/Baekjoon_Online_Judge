import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");  // 공백 제거 후, String 배열에 추가
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < str.length; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        
        Collections.sort(list);
        
        answer = list.get(0) + " " + list.get(str.length - 1);
        return answer;
    }
}