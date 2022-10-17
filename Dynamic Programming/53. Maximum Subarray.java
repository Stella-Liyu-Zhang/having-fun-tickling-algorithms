import static java.lang.Math.*;

//Time: O(N)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;

        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
