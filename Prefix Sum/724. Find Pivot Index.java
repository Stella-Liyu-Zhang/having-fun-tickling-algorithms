class Solution {
    /*
    Calculate sum,
    scan through nums,
        - if (sum - leftsum - nums[i] == leftsum){
            return i
        }
        leftsum += nums[i]
    return -1;
    */
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        int leftsum = 0;
        for(int i = 0; i < nums.length; i ++){
            if(sum - leftsum - nums[i] == leftsum){
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }
}