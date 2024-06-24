class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int l = j+1; l < nums.length; l++) {
                    sum = nums[i] + nums[j] + nums[l];
                    if (isPrimeNumber(sum)) answer++;
                }
            }
        }

        

        return answer;
    }
    
    boolean isPrimeNumber(int n) {
        
        int prv = (int)Math.sqrt(n);
        for (int i = 2; i<=prv; i++) {
            if (n%i==0) return false;  // 소수 아님
        }
        return true;
    }
}