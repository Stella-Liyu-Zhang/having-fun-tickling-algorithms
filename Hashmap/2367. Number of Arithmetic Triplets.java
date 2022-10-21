class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        Set<Integer> hs = new HashSet<>();
        for (int j = 0; j < nums.length; j++) {
            hs.add(nums[j]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hs.contains(nums[i] + diff) && hs.contains(nums[i] + 2 * diff)) {
                ans++;
            }
        }
        return ans;
    }
}

/*
 * 
 * Time complexity: O(n)
 * Space: O(n)
 * 
 */