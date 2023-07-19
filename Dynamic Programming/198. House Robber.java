class Solution {
    /*
     the only constraint is that we cannot rob 2 adjacent houses
     
     0 houses --> 0
     1 house --> rob it
     2 house --> rob the one with more money
     3 hhouses --> rob the 2 or 1+3?
     
     n houses --> amount of money
     
     bottom - up processing: 
     
     
    */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < dp.length; i ++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[dp.length-1];
    }
    /*
    Solution 2:
    class Solution {
        public int rob(int[] nums) {
            int prevNo = 0;
            int prevYes = 0;
            for(int n : nums){
                int temp = prevNo;
                prevNo = Math.max(prevNo, prevYes);
                prevYes = n + temp;
            }
            return Math.max(prevNo,prevYes);
        }
    }

    */
}