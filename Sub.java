class Solution {
    public static int countWays(String s1, String s2) {
        int MOD = 1000000007;
        int n = s1.length();
        int m = s2.length();
        // Initialize a 2D DP table with dimensions (n+1) x (m+1)
        int[][] dp = new int[n + 1][m + 1];
        
        // Base case initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        // DP table filling
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If characters match, we can either consider current characters
                // or exclude current character from s1.
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
                } else {
                    dp[i][j] = dp[i - 1][j];  // Exclude current character from s1
                }
            }
        }
        
        return dp[n][m];
    }
}
