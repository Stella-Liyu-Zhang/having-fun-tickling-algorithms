class Solution {
    /*
    Base casese:
    dp[0] = dp[0];
    dp[1] = Math.max(dp[0], dp[1])
    dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i])
    */
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i ++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}

//Optimized solution of O(1) space
class Solution {
    /*
    Base casese:
    dp[0] = dp[0];
    dp[1] = Math.max(dp[0], dp[1])
    dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i])
    */
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        //int[] dp = new int[nums.length];
        int robNextPlusOne = 0;
        int robNext = nums[nums.length-1]; 

        for(int i = nums.length - 2; i >= 0; i --){
            int curr = Math.max(robNext, robNextPlusOne + nums[i]);
            robNextPlusOne = robNext;
            robNext = curr;
        }
        return robNext;
    }
}