class Solution {
    /*
    The idea is to keep track of the first two numbers in increasing order and find the last number which will be bigger than the first two numbers. Here, the first and second smallest numbers can be updated with conditional checks while scanning nums.
    Time: O(N)
    Space: O(1)

    */
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int i: nums){
            if(i <= first){
                first = i;
            }else if (i <= second){
                second = i;
            }else{
                return true;
            }
        }
        return false;
    }
}