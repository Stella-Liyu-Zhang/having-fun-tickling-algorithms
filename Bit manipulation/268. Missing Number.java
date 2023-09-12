class Solution {
    /*
    XOR
    0 1 2 3
    0 1 3 4
    4^(0^0)^(1^1)^(2^3)^(3^4)
    = 2 
    SINCE (A^A) = A

    */
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i = 0; i < nums.length; i ++){
            res ^= nums[i]^i;
        }
        return res;
    }
}