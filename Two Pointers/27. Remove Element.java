class Solution {
    /*
    [3,2,2,3], val = 3

    Consider the elements to be removed as non-existent

    */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while(i < n){
            if(nums[i] == val){
                nums[i] = nums[n-1];
                n --;
            }else{
                i ++;
            }
        }
        return n;
    }
}