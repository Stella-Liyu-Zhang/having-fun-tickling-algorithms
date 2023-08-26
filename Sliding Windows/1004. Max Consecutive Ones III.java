class Solution {
    /*
    If we included a zero in the window we reduce the value of k.
    Since k is the maximum zeros allowed in a window.

    A negative k denotes we have consumed all allowed flips and window has
    more than allowed zeros, thus increment left pointer by 1 to keep the window size same.

    slow
    fast

    */
    public int longestOnes(int[] nums, int k) {
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] == 0){
                k --;
            }
            if(k < 0){
                if(nums[slow] == 0){// If the left element to be thrown out is zero we increase k.
                    k ++;
                }
                slow ++;
            }
            fast ++;
        }
        return fast - slow;
    }
}