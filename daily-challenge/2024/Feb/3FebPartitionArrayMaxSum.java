// https://leetcode.com/problems/partition-array-for-maximum-sum/

// Memoization solution
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, arr, k, dp, n);
    }
    
    private int solve(int index, int[] arr, int k, int[] dp, int n) {
        if(index == n) return 0;
        if(dp[index] != -1) return dp[index];
        int len = 0;
        int maxValue = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i = index; i < Math.min(index+k, n); i++) {
            len++;
            maxValue = Math.max(maxValue, arr[i]);
            int sum = (len * maxValue) + solve(i+1, arr, k, dp, n);
            maxSum = Math.max(sum, maxSum);
        }
        return dp[index] = maxSum;
    }
}
