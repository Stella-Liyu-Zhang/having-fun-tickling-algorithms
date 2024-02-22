class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int left = 0, right = 0;
        int count = 0, prod = 1;
        while(left < nums.length && right < nums.length){
            prod *= nums[right];
            while(prod >= k){
                prod /= nums[left];
                left ++;
            }
            count += right - left + 1;
            right ++;
        }
        return count;
    }
}