class Solution {
    /*
    [1,1,1,2,2,3]

    counter set to 1
    if equal to previous one, we would increment counter
    else, set counter to 1.
    If counter is within 2, we would NOT Remove the current one, set it in place
    Note that in the line "if(counter <= 2)", the 2 is the upper limit. 
    */
    public int removeDuplicates(int[] nums) {
        int counter = 1;
        int ptr = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == nums[i-1]){
                counter ++;
            }else{
                counter = 1;
            }
            if(counter <= 2){
                nums[ptr] = nums[i];
                ptr ++;
            }
        }
        return ptr;
    }
}