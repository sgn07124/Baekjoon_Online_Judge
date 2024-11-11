import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for (int a : arr) {
            if (a % divisor == 0) {
                list.add(a);
            }
        }
        if (list.size() == 0) {
            list.add(-1);
            return list.stream().mapToInt(i -> i).toArray();
        }
        Collections.sort(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}