import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        // 점수 역순으로 우선순위 큐에 넣는다.
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int a : A) queue.offer(a);
        
        // 점수 순으로 정렬하여 Deque에 삽입
        Arrays.sort(B);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int b : B) deque.offer(b);
        
        int answer = 0;
        while (!queue.isEmpty()) {
            int target = queue.poll();  // target: A의 사원
            // B팀의 최고 숫자가 A팀의 최고 숫자보다 높은 경우 승리
            if (target < deque.peekLast()) {
                deque.pollLast();
                answer++;
            } else {
                deque.pollFirst();  // 질 때는 가장 작은 숫자로 져야 함
            }
        }
        return answer;
    }
}