import java.util.*;

class Solution {
    public long solution(long n) {
        
        // 1. 문자열로 변경
        String str = "" + n;
        
        // 2. 배열에 담기
        int[] arr = new int [str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = (int)(n%10);
            n /= 10;
        }
        
        //3. 내림차순 정렬
        Integer[] result = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());
        
        long answer = 0;
        int a = result.length;
        
        for(int i=0; i<result.length; i++) {
            answer += result[i] * (long) Math.pow(10, a-1);
            a-=1;
        }
        
        
        return answer;
    }
}