class Solution {
    public int solution(int n) {
        int answer = 0;
        int nBinaryCount = countOne(n);
        
        while (true) {
            if(nBinaryCount == countOne(n+1)) {
                answer = n+1;
                break;
            }
            n++;
        }
        return answer;
    }
    
    public static int countOne(int n) {
        String nBinary = Integer.toBinaryString(n);  // n을 2진수 문자열 변환
        int nCnt = 0;
        for(int i = 0; i < nBinary.length(); i++) {
            if(nBinary.charAt(i) == '1') {
                nCnt++;
            }
        }
        return nCnt;
    }
}