class Solution {
    /*
    The farthest position changes
    begin, end, use any of these values within the range to the begining point of the next jump

    update end to the farthest positon

    once we reach the end 


    */
    public int jump(int[] nums) {
        int jumpTimes = 0;
        int end = 0, farthest = 0;

        for(int i = 0; i < nums.length - 1; i ++){
            farthest = Math.max(farthest, i + nums[i]);

            if(i == end){
                jumpTimes ++;
                end = farthest;
            }
        }
        return jumpTimes;
    }
}