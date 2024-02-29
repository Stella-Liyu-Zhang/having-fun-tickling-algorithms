class Solution {
    public int search(int[] nums, int target) {
        // nums[i] > nums[i+1]
        int left = 0;
        int right = nums.length- 1;

        while (left <= right){
            int mid = (left + right )/2;
            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]){ //left half is sorted
                if (target >= nums[left] && target <= nums[mid]){ //key is in left half
                    right = mid - 1;  
                }else{
                    left = mid + 1;
                }
            }
            if (nums[mid] <= nums[right]){// right half is sorted
                if (target >= nums[mid] && target <= nums[right]){ //key is in right half
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

//second attempt
class Solution {
    /*

    binary search

    pivot k can be at the start, or bottom or anywhere
    after shifting, looks like 2 increasing subarrays
    nums == target, return index
    nums > target{
        1) if nums[mid] > nums[left]
    }
    */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int midEle = nums[mid];
            if(midEle == target){
                return mid;
            }else if (nums[mid] >= nums[left]){ //left is sorted 
                if(target < nums[mid] && target >= nums[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{ //right is sorted 
                if(target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}