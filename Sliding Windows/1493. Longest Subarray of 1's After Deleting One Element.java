class Solution {
    public int longestSubarray(int[] nums) {
        int left= 0;
        int right = 0;
        int toDelete = 1;
        while(right < nums.length){
            if(nums[right] == 0){
                toDelete --;
            }
            if(toDelete < 0){
                if(nums[left] == 0){
                    toDelete ++;
                }
                left ++;
            }
            right ++;
        }
        return right - left - 1;
    }
}