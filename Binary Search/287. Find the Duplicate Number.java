class Solution {
    public int findDuplicate(int[] nums) {
        // low and high represent the range of values of the target
        int low = 1;
        int high = nums.length - 1;
        int dup = -1;

        while (low <= high) {
            int cur = (low + high) / 2;
            // count how many numbers are less than or equal to 'cur'
            int count = 0;
            for (int num : nums) {
                if (num <= cur) {
                    count++;
                }
            }

            if (count > cur) {
                dup = cur;
                high = cur - 1;
            } else {
                low = cur + 1;
            }
        }
        return dup;
    }
}