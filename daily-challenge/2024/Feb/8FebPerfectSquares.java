// https://leetcode.com/problems/perfect-squares/?envType=daily-question&envId=2024-02-08
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
    
    private int solve(int n, int[] dp) {
        if(n == 0)
            return 0;
        if(dp[n] != -1)
            return dp[n];
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i*i <= n; i++) {
            int res = 1 + solve(n - i*i, dp);
            min = Math.min(res, min);
        }
        return dp[n] = min;
    }
}
