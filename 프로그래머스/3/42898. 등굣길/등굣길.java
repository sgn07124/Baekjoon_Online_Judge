class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int [][] dp = new int [n + 1][m + 1];
        int mod = 1000000007;
        
        for (int [] temp : puddles) {
            dp[temp[1]][temp[0]] = -1;
        }
        
        dp[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    continue;  // 물에 잠긴 지역
                }
                if (dp[i - 1][j] > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                }
                if (dp[i][j - 1] > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;
                }
            }
        }
        return dp[n][m];
    }
}