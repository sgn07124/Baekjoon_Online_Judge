import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int len = citations.length;  // 논문 개수
        Arrays.sort(citations);
        
        for (int i = 0; i < len; i++) {
            // 논문 i번째의 인용 횟수가 남은 논문 개수 이상일 경우 조건을 만족함
            if (citations[i] >= len - i) {
                return len - i;
            }
        }
        return 0;
    }
}