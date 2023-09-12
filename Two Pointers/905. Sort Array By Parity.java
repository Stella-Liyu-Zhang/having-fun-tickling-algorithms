class Solution {
    /*
    even 
    i 
    j 
    */
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] ans = new int[nums.length];
        for(int num: nums){
            if(num % 2 ==  0){
                ans[i] = num;
                i ++;
            }else{
                ans[j] = num;
                j --;
            }
        }
        return ans;
    }
}