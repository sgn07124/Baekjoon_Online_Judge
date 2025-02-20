import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);  // 오름차순 정렬
        int left = 0;
        int right = people.length - 1;
        // 투 포인터
        // 오름차순 정렬이 된 상태에서 if문이 성립되지 않아 right--가 되면, 해당 값(people[right])은 하나의 보트에 탑승한다.
        while (left <= right) {
            if (limit >= people[left] + people[right]) left++;
            right--;
            answer++;
        }
        return answer;
    }
}