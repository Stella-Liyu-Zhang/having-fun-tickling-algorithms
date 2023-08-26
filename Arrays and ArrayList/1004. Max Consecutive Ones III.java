class Solution {
    /*
    keep track of slow pointer, pointing to the left
    return the final max length


    */
    public int longestOnes(int[] nums, int k) {
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if(nums[fast] == 0){
                k--;
            }
            if(k < 0){
                if(nums[slow] == 0){
                    k ++;
                }
                slow ++;
            }
            fast ++;
        }
        return fast - slow;
    }
}