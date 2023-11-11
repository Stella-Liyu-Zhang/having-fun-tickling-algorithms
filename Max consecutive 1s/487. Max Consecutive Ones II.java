class Solution {
    /*
    flip at most 1 0s

    sliding window

    chancestoFlip = 1
    nums[i] == 0
    chancestoFlip --

    Time: O(N)
    Space: O(1)

    */
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0;
        int chancestoFlip = 1;

        while(right < nums.length){
            if(nums[right] == 0){
                chancestoFlip --;
            }
            if(chancestoFlip < 0){
                if(nums[left] == 0){
                    chancestoFlip ++;
                }
                left ++;
            }
            right ++;
        }
        return right - left;

    }
}
