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

class Solution {
    /*
    chancestoFlip = 1;
    left 
    right
    */
    public int findMaxConsecutiveOnes(int[] nums) {
        int chancestoFlip = 1;
        int left = 0;
        int right = 0;

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