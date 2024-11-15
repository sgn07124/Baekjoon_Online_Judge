class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (isSum(n, i) == true) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static boolean isSum(int n, int i) {
        int sum = 0;
        for (int j = i; j <= n; j++) {
            sum += j;
            if (sum == n) {
                return true;
            } else if (sum > n) {
                break;
            } 
        }
        return false;
    }
 }