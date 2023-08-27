class Solution {
    public void moveZeroes(int[] nums) {
        int toInsert = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != 0){
                nums[toInsert] = nums[i];
                toInsert ++;
            }
        }
        for(int j = toInsert; j < nums.length; j ++){
            nums[j] = 0;
        }
    }
}