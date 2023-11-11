class Solution {
    /*
    return the max number of consecutive 1s
    one scan
    1 -> update the current consecutive length
     -> make it to 0
    
    Note that we try to get the max only when i == 1!!!
    */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0, len = 0;
        for(int i : nums){
            if(i == 1){
                len ++;
                maxLen = Math.max(len, maxLen);
            }else{
                len = 0;
            }
        }
        return maxLen;
    }
}