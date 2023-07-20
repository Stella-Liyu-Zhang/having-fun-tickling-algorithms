class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int output = 0;
        Arrays.sort(nums); // Sort the array to use the two-pointer approach

        for(int i = 0; i < nums.length - 2; i ++){
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right){
                int currSum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target-currSum);
                if (diff < closest){
                    closest = diff;
                    output = currSum;
                }
                if (currSum < target){
                    left ++;
                }else{
                    right--;
                }
            }
        }
        return output;
    }
}