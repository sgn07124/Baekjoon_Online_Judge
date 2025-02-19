import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            int cnt = divisor(i);
            if (cnt % 2 == 0) answer += i;
            else answer -= i;
        }
        
        return answer;
    }
    
    public int divisor(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) cnt++;
        }
        return cnt;
    }
}