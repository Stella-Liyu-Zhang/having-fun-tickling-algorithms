class Solution {
    /*
    target
    nums[]
    left: 0
    right: nums.length - 1
    mid
    -> find the biggest element that is smaller than target in nums
    -> return its index
    There will be a point where left and right and pivot all pointing to the same position,
    if we continue, then right = left - 1;
    break the loop, we will be returning left
    */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){ // if left and right point to the same value
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){ //
                left = mid + 1;
            }else{
                right = mid - 1; //shrinking down the range
            }
        }
        return left;
    }
}