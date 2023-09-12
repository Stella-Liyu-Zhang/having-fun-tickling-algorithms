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

//solution 2
class Solution {
    /*
(A[i] % 2, A[j] % 2):

If it is (0, 1), then everything is correct: i++ and j--.
If it is (1, 0), we swap them so they are correct, then continue.
If it is (0, 0), only the i place is correct, so we i++ and continue.
If it is (1, 1), only the j place is correct, so we j-- and continue.
    */
    public int[] sortArrayByParity(int[] nums) {
       int i = 0;
       int j = nums.length - 1;
       while(i < j){
           int r1 = nums[i] % 2;
           int r2 = nums[j] % 2;
           if(r1 < r2){
               i ++;
               j --;
           }else if (r1 > r2){
               int temp = nums[i];
               nums[i] = nums[j];
               nums[j] = temp;
           }
           if(r1 == 0 && r2 == 0){
               i ++;
           }
           if(r1 == 1 && r2 == 1){
               j --;
           }
       }
       return nums;
    }
}