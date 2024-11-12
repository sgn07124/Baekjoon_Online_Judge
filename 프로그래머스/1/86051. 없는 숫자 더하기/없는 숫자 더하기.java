class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        for (int i = 0; i <= 9; i++) {
            boolean flag = false;
            for(int j : numbers) {
                if (i == j) {
                    flag = true;
                    continue;
                }
            }
            if (flag == false) {
                answer += i;
            }
            
        }
        return answer;
    }
}