class Solution {
    /*
    maxSum current
    maxSumsofar
    Time: O(N)
    Space: O(1)

    */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int maxSumsoFar = nums[0];
        for(int i = 1; i < nums.length; i ++){
            maxSum = Math.max(nums[i], maxSum + nums[i]);
            maxSumsoFar = Math.max(maxSumsoFar, maxSum);
        }
        return maxSumsoFar;
    }
}