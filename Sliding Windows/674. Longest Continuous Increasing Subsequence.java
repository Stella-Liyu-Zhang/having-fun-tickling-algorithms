/*
Sliding windows: longest sub-thing
moving along, return the difference between the boundaries

Time complexity is O(n)
Space compexity O(1)
*/
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int anchor = 0;

        for (int i = 0; i < nums.length; i++) {
            // "<=" is important here because if "22222", it's not incrementing at all! So
            // we need to update the anchor to the next i.
            if (i > 0 && nums[i] <= nums[i - 1]) {
                anchor = i;

            }
            ans = Math.max(ans, i - anchor + 1);
        }

        return ans;
    }
}