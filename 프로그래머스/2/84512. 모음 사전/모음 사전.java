import java.util.*;

class Solution {
    ArrayList<String> dict = new ArrayList<>();
    String std = "AEIOU";
    
    // 재귀적으로 호출되어 cmd 문자열을 구성해 나가면서 모든 단어를 dict 리스트에 추가
    public void init(int num, int cnt, String cmd) {  // num: 현재 단어의 길이
        // cmd가 길이에 맞게 완성되면 dict에 추가
        if (num == cnt) {
            dict.add(cmd);
            return;
        }
        
        // 'A', 'E', 'I', 'O', 'U' 중 하나의 문자를 선택하여, 해당 문자를 cmd에 붙여가며 재귀적으로 호출
        for (int i = 0; i < 5; i++) {
            init(num, cnt + 1, cmd + Character.toString(std.charAt(i)));
        }
    }
    
    public int solution(String word) {
        
        // 길이가 1 ~ 5인 모든 단어를 dict에 추가
        for (int i = 1; i <= 5; i++) {
            init(i, 0, "");
        }
        
        // 사전순으로 정렬
        Collections.sort(dict);
        int idx = 1;
        
        // word와 일치하는 단어의 순서(idx)을 반환
        for (String s : dict) {
            if (s.equals(word)) {
                return idx;
            }
            idx++;
        }
        return idx;
    }
}