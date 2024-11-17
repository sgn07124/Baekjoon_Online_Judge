import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        // 정수형 numbers를 String형 배열로 변환
        String[] strNumbers = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        
        // 내림차순 정렬. (a+b)와 (b+a)를 기준으로 하여 정렬을 진행한다.(문자열이므로 a가 앞에 오는지, b가 앞에 오는지에 따라 정렬됨)
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        for (String num : strNumbers) {
            sb.append(num);
        }

        // sb의 맨 앞 숫자가 0인 경우는 아무것도 없는 값의 경우이므로 0을 반환
        if (sb.toString().charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}