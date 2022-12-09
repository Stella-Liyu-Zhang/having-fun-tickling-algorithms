class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        ans[0] = findFirst(nums, target);
        ans[1] = findSecond(nums, target);
        return ans;
    }
    //[5,7,7,8,8,10], target = 8
    private int findFirst(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int start = -1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            if (nums[mid] == target){
                start = mid; //this is the start
                right = mid - 1; //let's see if there is one more on the left.
            }
        }
        return start;
    }
    private int findSecond(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int end = -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] > target){
                right = mid-1;
            }else{
                left = mid + 1;
            }
            if (nums[mid] == target){
                end = mid; //this is the end
                left = mid + 1;// lets see if there is one more on the right
            }
        }
        return end;
    }
}