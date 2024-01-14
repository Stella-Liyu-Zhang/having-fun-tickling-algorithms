class Solution {
    /*
    Time: O(N)
    Space: O(1)
    */
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList();
        for(int i = 0; i < nums.length; i ++){
            int start = nums[i];
            //move the i pointer to the end of the range 
            while(i < nums.length -1 && nums[i] + 1 == nums[i+1]){
                i ++;
            }
            //i is pointing to the end of the range
            if(start != nums[i]){
                ranges.add(start + "->" + nums[i]);
            }else{
                ranges.add(String.valueOf(start));
            }
        }
        return ranges;
    }
}