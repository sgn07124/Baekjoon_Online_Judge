class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int cnt = 0;
        char[] str = s.toCharArray();
        for (char c : str) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') cnt--;
            if (cnt < 0) return false;
        }
        if (cnt == 0) answer = true;
        
        

        return answer;
    }
}