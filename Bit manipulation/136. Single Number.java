class Solution {
    /*
    XOR used here....if a=b then a^b=1 so
    if nums= 4,1,2,1,2
    ans=4^1^2^1^2
    here 2^2 and 1^1 both will be cancel out and 4 is only one so it will not be cancelled out
    */
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num: nums){
            result = result ^ num;
        }
        return result;
    }
}