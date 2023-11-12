class Solution {
    /*
    Max consecutive 1s
    flip at most k 0s

    maxtoFlip = k
    maxtoFlip -- when come across a 0
    maxtoFlip < 0, 
    left ? 0 
    */
    public int longestOnes(int[] nums, int k) {
        int maxtoFlip = k;
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                maxtoFlip --;
            }
            if(maxtoFlip < 0){
                if(nums[left] == 0){
                    maxtoFlip ++;
                }
                left ++;
            }
            right ++;
        }
        return right - left;
    }
}
