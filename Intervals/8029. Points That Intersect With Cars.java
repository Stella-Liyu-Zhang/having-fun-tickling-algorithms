class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int ans = 0;
        Collections.sort(nums, Comparator.comparing(list -> list.get(0)));
        
        if(nums.size() == 0){
            return 0;
        }
        
        int prevBiggest = nums.get(0).get(1);
        ans += prevBiggest - nums.get(0).get(0) + 1;
        
        for(int i = 1; i < nums.size(); i ++){
            int currentStart = nums.get(i).get(0);
            int currentEnd = nums.get(i).get(1);

            if (currentStart > prevBiggest) {
                ans += currentEnd - currentStart + 1;
            } else if (currentEnd > prevBiggest) {
                ans += currentEnd - prevBiggest;
            }

            prevBiggest = Math.max(prevBiggest, currentEnd);
        }
        return ans;
    }
    
}