import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean [] visited = new boolean [words.length];
        Queue<Integer> queue = new LinkedList<>();
        
        // 첫 번째로 변환 가능한 문자열의 인덱스를 큐에 추가
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (canConvert(begin, word)) {
                visited[i] = true;
                queue.add(i);
                break;
            }
        }
        
        int cnt = 1;
        
        // bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = words[queue.poll()];
                
                if (cur.equals(target)) return cnt;
                
                for (int i = 0; i < words.length; i++) {
                    if (visited[i]) continue;
                    String str = words[i];
                    if (canConvert(cur, str)) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
            cnt++;
        }
        return 0;
    }
    
    private boolean canConvert(String from, String to) {
        int cnt = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) == to.charAt(i)) cnt++;
        }
        return from.length() == cnt + 1 ? true : false;
    }
}