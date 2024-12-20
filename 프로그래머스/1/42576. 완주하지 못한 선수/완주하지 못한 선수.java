import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // participant: ["mislav", "stanko", "mislav", "ana"]
        // completion: ["stanko", "ana", "mislav"]

        Set<String> par = new HashSet<>();

        for (String runner : participant) {
            if (!par.contains(runner)) {
                par.add(runner);
            } else {
                par.remove(runner);
            }
        }
        // par = ["stanko", "ana"]

        for (String runner : completion) {
            if (par.contains(runner)) {
                par.remove(runner);
            } else {
                par.add(runner);  // 완주 못한 사람
            }
        }
        // par = ["mislav"]

        for (String failure : par) {
            return failure;
        }
        return null;
    }
}