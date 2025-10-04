import java.util.*;

class Solution {
    
    static List<String> answerList = new ArrayList<>();
    static Map<String, Integer> hashMap = new HashMap<>();  // 조합, 개수
    
    public String[] solution(String[] orders, int[] course) {
        
        // 1. 각 order 정렬
        for (int i = 0; i < orders.length; i++) {
            char [] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }
        
        // 2. 각 order를 기준으로 각 course 개수 만큼의 조합 만들기
        for (int courseLength : course) {
            for (String order : orders) {
                combination("", order, courseLength);
            }
            
            // 3. 가장 많은 조합을 answer에 저장
            if (!hashMap.isEmpty()) {
                List<Integer> countList = new ArrayList<>(hashMap.values());  // hashMap의 value 중 max 값을 찾아야 하므로 리스트에 저장
                int max = Collections.max(countList);  // 최댓값을 저장(조합의 최대 개수)
                
                if (max > 1) {  // max > 1인 경우 -> "최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만"
                    for (String key : hashMap.keySet()) {  // hashMap을 돌면서 각 key에 대한 value가 max인 값을 정답 리스트에 추가
                        if (hashMap.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
                hashMap.clear();  // 비우고 다음 course 진행
            }
        }
        
        Collections.sort(answerList);
        String [] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    // order: 현재까지 조합된 코스
    // others: 아직까지 사용되지 않은 알파벳
    // count: 몇 개를 더 조합해야 되는지에 대한 개수
    static void combination(String order, String others, int count) {
        // 탈출 조건: count == 0
        if (count == 0) {
            hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
            return;
        }
        
        // 수행 동작: 0부터 length 까지 조합
        for (int i = 0; i < others.length(); i++) {
            combination(order + others.charAt(i), others.substring(i + 1), count - 1);
        }
    }
}