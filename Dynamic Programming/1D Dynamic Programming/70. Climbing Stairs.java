class Solution {
    /*
    dp[i]: number of ways to get to ith position
    1) i-1 -> i = 1 step
    2) i-2 -> i = 2 steps

    */
    public int climbStairs(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i ++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}