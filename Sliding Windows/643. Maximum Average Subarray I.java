class Solution {
    /*
    So the trick here is to subtract the element nums[i] from x and to add the element nums[i+k+1] to x
    Use sum to perform the sliding window operation.
    Use res to store the maximum value each time
    Time: O(N)
    Space: O(1)
    */
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i = 0; i < k; i ++){
            sum += nums[i];
        }
        double res = sum;
        for(int i = k; i < nums.length; i++){
            sum += nums[i] - nums[i-k];
            res = Math.max(res, sum); 
        }
        return res/k;
    }
}