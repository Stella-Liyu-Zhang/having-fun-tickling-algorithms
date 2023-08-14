class Solution {
    /*
        subarray 
        conriguous subarray 

        Brutal force: O(n^2)
        already evaluated n-1 maximum sum, we just add the new one, and 
        aggregated
        keep track of all the max sums
        dynammic programming kadane's algo

        [5,4,-1,7,8]
        5 9 8 15
        5 9 9 15
   
        Time: O(n)
        Space: O(1)
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int maxSofar = nums[0];
        int currMax = nums[0];
        for(int i = 1; i < nums.length; i ++){
            currMax = Math.max(nums[i], nums[i] + currMax);
            maxSofar = Math.max(maxSofar, currMax);
        }
        return maxSofar;
        
    }
}