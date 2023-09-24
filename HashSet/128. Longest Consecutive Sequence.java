class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int n: nums){
            set.add(n);
        }
        int maxLen = 0;
        for(int num: set){
            if(!set.contains(num-1)){
                int currNum = num;
                int currLen = 1;

                while(set.contains(currNum + 1)){
                    currLen ++;
                    currNum ++;
                }
                maxLen = Math.max(currLen, maxLen);
            }
        }
        return maxLen;
    }
}