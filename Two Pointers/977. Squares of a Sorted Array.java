class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] ans = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i --){
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                ans[i] = nums[right]*nums[right];
                right --;
            }else{
                ans[i] = nums[left]*nums[left];
                left ++;
            }
        }
        return ans;
    }
}