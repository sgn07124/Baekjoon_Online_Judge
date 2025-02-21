import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);  // 작업일
            queue.offer(day);
        }
        
        List<Integer> releaseFunction = new ArrayList<>();
        while (!queue.isEmpty()) {
            int releaseDay = queue.poll();  // 배포일 빼놓고
            int releaseFunctionCount = 1;  // 앞의 1개
            
            while (!queue.isEmpty() && releaseDay >= queue.peek()) {  // releaseDay가 크거나 같다는 의미는 뒤의 작업은 이미 완료가 됬다는 의미
                queue.poll();
                releaseFunctionCount++;  // 하루에 배포할 기능 증가
            }
            releaseFunction.add(releaseFunctionCount);
        }
        return releaseFunction;
    }
}

