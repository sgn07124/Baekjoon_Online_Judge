import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> ponkets = new HashMap<>();
        for (int num : nums) {
            ponkets.put(num, ponkets.getOrDefault(num, 0) + 1);
        }
        
        int sel = nums.length / 2;
        if (sel <= ponkets.size()) {
            return sel;
        } else {
            return ponkets.size();
        }
    }
}