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