class Solution {
    /*
    Time: O(N)
    Space: O(1)
    */
    public int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        int countDups = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == nums[i-1]){
                countDups ++;
            }else{
                countDups = 1;
            }
            if(countDups <= 2){
                nums[insertIndex] = nums[i];
                insertIndex ++;
            }
        }
        return insertIndex;
    }
}