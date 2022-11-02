class Solution {
    public void nextPermutation(int[] nums) {
        // the next lexicographically greater permutation of its integer
        /*
         * [1,2,3] Three slots, placing each one of the letters in a slot
         * 1) find the first decreasing sequence starting from the end
         * 2) find the the number which is just larger than itself among the numbers
         * lying to its right section, say a[j], for substitution and perform swap
         * 3) rearrange remaning array by reversing it
         * Time O(N) space O(1)
         */

        // find the first decreasing sequence starting from the end
        // a[i]a[i] and a[i-1]a[i−1] where, a[i] > a[i-1]a[i]>a[i−1]
        int first = nums.length - 2;
        while (first >= 0 && nums[first] >= nums[first + 1]) {
            first--;
        }
        if (first >= 0) {
            int justLargest = nums.length - 1;
            while (justLargest >= 0 && nums[justLargest] <= nums[first]) {
                justLargest--;
            }
            swap(nums, justLargest, first);
        }
        // rearrange the remaning array by reversing it
        reverse(nums, first + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}