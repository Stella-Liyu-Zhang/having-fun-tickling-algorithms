class Solution {
    /*
    Time: O(N)
    Space: O(N)
    */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int[] res = new int[2];

        for(int i = 0; i < nums.length; i ++){
            if(map.containsKey(target - nums[i])){
                res[1] = i;
                res[0] = map.get(target-nums[i]); 
                return res;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}