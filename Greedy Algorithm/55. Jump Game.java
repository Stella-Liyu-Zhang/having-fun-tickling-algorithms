class Solution {
    /*
    the maximum jump length at that position

    [2,3,1,1,4]
    go backwards
    keep track of what spot you can get to the last index from?

    [2,3,1,1,4]
    int lastGoodIndexPosition = 4

    */
    public boolean canJump(int[] nums) {
        int lastGoodIndexPosition = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i + nums[i] >= lastGoodIndexPosition){
                lastGoodIndexPosition = i;
            }
        }
        return lastGoodIndexPosition == 0;
    }
}