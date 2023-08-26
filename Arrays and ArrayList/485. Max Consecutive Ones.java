class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currLen = 0;
        int maxLen = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == 1){
                currLen ++;
                maxLen = Math.max(maxLen, currLen);
            }else{
                currLen = 0;
            }
        }
        return maxLen;
    }
}