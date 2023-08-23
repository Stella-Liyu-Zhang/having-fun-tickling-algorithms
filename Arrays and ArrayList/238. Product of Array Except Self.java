class Solution {
    /*
    Numbers:     2    3    4     5
    Lefts:       1    2  2*3 2*3*4
    Rights:  3*4*5  4*5    5     1
    */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int left = 1;
        for(int i = 0; i < n; i ++){
            if(i > 0){
                left = left*nums[i-1];
            }
            res[i] = left;
        }
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i --){
            if(i < nums.length - 1){
                right = right*nums[i+1];
            }
            res[i] *= right;
        }
        return res;
    }
}