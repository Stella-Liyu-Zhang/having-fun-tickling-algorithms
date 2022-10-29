class Solution {
    public int minStartValue(int[] nums) {
        // Return the minimum positive value of startValue such that the step by step
        // sum is never less than 1.
        /*
         * prefix sum
         * Get the smallest value of all the sums starting from index 0 to nums.length -
         * 1
         * if it's negative, we get its absolute value, then plus 1
         * if it's positive, we plus 1
         */
        if (nums == null) {
            throw new IllegalArgumentException("Input array is null");
        }
        int min = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            // Find the minimum prefix sum which is <= zero, as it will help us to find the
            // lowest negative value.
            min = Math.min(min, prefixSum);
        }
        return 1 - min;
    }
}
