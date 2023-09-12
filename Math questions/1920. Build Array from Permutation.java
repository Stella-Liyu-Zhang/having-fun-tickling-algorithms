class Solution {
    /*
    meta = nums[i] + (some_constant) * nums[nums[i]];
    0 - 1000, so we take 1001
    meta = a + 1001*b
    num = meta/c
    */
    public int[] buildArray(int[] nums) {
        int CONST = 1001;
        for(int i = 0; i < nums.length; i ++){
            int a = nums[i];
            int b = nums[a]%CONST;
            nums[i] = a + b*CONST;
        }
        for(int i = 0; i < nums.length; i ++){
            nums[i]/=CONST;
        }
        return nums;
    }
}