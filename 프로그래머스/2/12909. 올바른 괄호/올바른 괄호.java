class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int cnt = 0;
        char[] str = s.toCharArray();
        for (char c : str) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') cnt--;
            
            if (cnt < 0) return false;  // cnt 값이 음수가 되면 괄호가 제대로 짝지어지지 않은 것
        }
        if (cnt == 0) answer = true;
        
        return answer;
    }
}