class Solution {
    /*
    reverse the array,
    reverse the array from 0 to k-1,
    reverse the array from k to nums.length - 1
    [1,2,3,4,5,6,7],
    [7,6,5,4,3,2,1], k = 3
    [5,6,7,1,2,3,4]
    */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        rotateArray(nums, 0, n-1);
        rotateArray(nums, 0, k-1);
        rotateArray(nums, k, n-1);
    }
    private void rotateArray(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}