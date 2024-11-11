class Solution {
    public int solution(int num) {
        int answer = 0;
        
        while (true) {
            if (num == 1) {
                return answer;
            }
            if (num % 2 == 0) {
                num /= 2;
                answer++;
            } else if (num % 2 != 0) {
                num *= 3;
                num += 1;
                answer++;
            }
            if (num <= 0) {
                return -1;
            }
            if (answer == 500) {
                return -1;
            }
            
        }
    
    }
}