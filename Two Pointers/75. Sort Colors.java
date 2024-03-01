class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int i = 0;
        int right = nums.length - 1;
        while(i <= right){
            if(nums[i] == 0){
                swap(nums, i, left);
                left ++;
                i ++;
            }else if (nums[i] == 1){
                i ++;
            }else{
                // i, left has already been processed
                // when we go from the right, not everything ha been processed and we cannot skip by i ++ ;
                swap(nums, i , right);
                right --;
            }
        }
    }
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}