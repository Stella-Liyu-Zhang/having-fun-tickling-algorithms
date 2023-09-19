class Solution {
    /*
    2,2,1,1,1,2,2
    count 2,0 
    0+1
    0
    2
    Boyer-Moore  algorithm 
    */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for(int num: nums){
            if(count == 0){
                candidate = num;
            }
            if(num == candidate){
                count ++;
            }else{
                count --;
            }
        }
        return candidate;
    }
}