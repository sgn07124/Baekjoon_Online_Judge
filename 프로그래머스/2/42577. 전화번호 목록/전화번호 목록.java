import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> numbers = new HashSet<>();
        for (String number : phone_book) {
            numbers.add(number);
        }
        StringBuilder sb = new StringBuilder();
        for (String number : phone_book) {
            char [] arr = number.toCharArray();
            
            for (int i = 0; i < arr.length - 1; i++) {
                sb.append(arr[i]);
                if (numbers.contains(sb.toString()))
                    return false;
            }
            sb.setLength(0);
        }

        return true;
    }
}