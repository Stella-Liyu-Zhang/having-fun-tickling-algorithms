class Solution {
    /*
     * 1,2,3,4,5,6,7
     * reverse all numbers 7654321
     * reverse first k numbers 5671234
     * reverse last n - k numbers
     * 
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            // reverse nums[i] and nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

//I initially came across a bad solution 
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 1 || k > nums.length){
            return;
        }
        int[] temp = new int[2*nums.length];
        for(int i = 0; i < nums.length; i ++){
            temp[i] = nums[i];
        }
        for(int i = nums.length; i < temp.length; i++){
            temp[i] = nums[i-nums.length];
        }

        for(int i = 0; i < nums.length; i ++){
            nums[i] = temp[i+nums.length-k];
        }
    }
}