class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            System.out.println("left: " + left + "right: " + right);
            if(nums[mid] == nums[mid+1]){
                int leftRemain = (mid - left)%2;
                int rightRemain = (right - mid - 1)%2;
                if(leftRemain % 2 != 0){ //left is odd
                    right = mid - 1;
                }else{ //right is odd
                    left = mid + 2;
                }
            }else if (nums[mid] == nums[mid-1]){
                int leftRemain = (mid -1- left)%2;
                int rightRemain = (right - mid )%2;
                if(leftRemain % 2 != 0){ //left is odd
                    right = mid - 2;
                }else{ //right is odd
                    left = mid + 1;
                }
            }else{
                return nums[mid];
            }
        }
        return nums[left];
    }
}