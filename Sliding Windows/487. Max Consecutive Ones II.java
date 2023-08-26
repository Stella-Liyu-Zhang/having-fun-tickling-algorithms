class Solution {
    /*
    slow
    fast
    k = 1
    k --
    k < 0
    if(nums[slow] == 0){
        k ++;
    }
    O(n)
    O(1)
    */
    public int findMaxConsecutiveOnes(int[] nums) {
        int slow = 0, fast = 0;
        int k = 1;
        while(fast < nums.length){
            if(nums[fast] == 0){
                k --;
            }
            if (k < 0){
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