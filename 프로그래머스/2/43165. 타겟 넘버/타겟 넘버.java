class Solution {
    int numbers [];
    int target;
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        return answer;
    }
    
    void dfs(int index, int sum) {
        // 1. 탈출 조건
        if (index == numbers.length) {  // 마지막 인덱스 == 숫자 개수
            if (sum == target) answer++;  // 숫자 합이 target과 같으면 증가
            return;
        }
        
        // 2. 수행 동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}