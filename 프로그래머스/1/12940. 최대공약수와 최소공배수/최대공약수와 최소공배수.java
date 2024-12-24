class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if (n >= m) {
            answer[0] = getGcd(n, m);
        } else
            answer[0] = getGcd(m, n);
        answer[1] = ((n * m) / answer[0]);

        return answer;
    }

    public static int getGcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGcd(num2, num1 % num2);
    }
}