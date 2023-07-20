class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        // store the result that is the max we have found so far
        int maxproduct = nums[0];

        int currmax = maxproduct, currmin = maxproduct;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currmax;
                currmax = currmin;
                currmin = temp;
            }
            ;

            // max/min product for the current number is either the current number itself or
            // the max/min product by the previous number times the current one.
            currmax = Math.max(nums[i], currmax * nums[i]);
            currmin = Math.min(nums[i], currmin * nums[i]);

            // the newly computed max value is a candidate for our global result
            maxproduct = Math.max(currmax, maxproduct);
        }
        return maxproduct;
    }
}