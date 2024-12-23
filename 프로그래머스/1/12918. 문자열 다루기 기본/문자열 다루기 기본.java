class Solution {
    public static boolean solution(String s) {
        System.out.println(s.length());
        if (s.length() == 4 || s.length() == 6) {
            for (int i = 0; i < s.length(); i++) {
                if (!((int)s.charAt(i) >= 48 && (int)s.charAt(i) <= 57)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}