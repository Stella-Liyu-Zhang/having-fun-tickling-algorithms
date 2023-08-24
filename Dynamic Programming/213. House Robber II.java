class Solution {
    /*
    skip the last house or skip the first house

    */
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] skipLast = new int[nums.length - 1];
        int[] skipFirst = new int[nums.length - 1];
        for(int i = 0; i < nums.length-1; i ++){
            skipLast[i] = nums[i];
            skipFirst[i] = nums[i+1];
        }
        return Math.max(robHelper(skipLast),robHelper(skipFirst));
    }
    private int robHelper(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] total = new int[nums.length + 1];
        total[0] = nums[0];
        total[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i ++){
            total[i] = Math.max(total[i-2] + nums[i], total[i-1]);
        }
        return total[nums.length-1];
    }
}