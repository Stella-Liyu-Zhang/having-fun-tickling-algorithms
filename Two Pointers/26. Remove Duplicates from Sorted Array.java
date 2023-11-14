class Solution {
    /*
    
    Sorted in an ascending order

    dupps appears,
    1 pointer to scan through
    1 pointer to keep track of the index we place things
    index: represent where we should place the new number if it is unique!

    first number is always unique
    start at 1
    [0,0,1,1,1,2,2,3,3,4]
    0 1 2
    */
    public int removeDuplicates(int[] nums) {
        int ptr = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] != nums[i-1]){
                nums[ptr] = nums[i];
                ptr ++;
            }
        }
        return ptr;
    }
}