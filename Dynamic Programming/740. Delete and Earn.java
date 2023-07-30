class Solution {
    public int deleteAndEarn(int[] nums) {
        //sort the nums array
        int[] dp = new int[10001];
        for(int num: nums){
            dp[num] += num;
        }
        int take = 0;
        int skip = 0;
        for(int i = 0; i < 10001; i ++){
            int takei = skip + dp[i];
            int skipi = Math.max(take, skip);
            take = takei;
            skip = skipi;
        }
        return Math.max(take,skip);
    }
}