class Solution {
    /*
    Get the shortest subarray with the maximum frequency
    Use 2 hashmaps to store
    1. The frequency
    2. The first occurence index

    Time: O(N)
    Space: O(N)

    If a has the maximum frequency,
    update the degree = count[a] and res = i - first[A[i]] + 1.

    If a is one of the numbers that has the maximum frequency,
    update the res = min(res, i - first[A[i]] + 1)

    */
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap();
        HashMap<Integer, Integer> first = new HashMap();
        int degree = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i ++){
            first.putIfAbsent(nums[i], i);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if(freq.get(nums[i]) > degree){
                degree = freq.get(nums[i]);
                ans = i - first.get(nums[i]) + 1;
            }else if (freq.get(nums[i]) == degree){
                ans = Math.min(ans, i - first.get(nums[i]) + 1);
            }
        }
        return ans;
    }
}