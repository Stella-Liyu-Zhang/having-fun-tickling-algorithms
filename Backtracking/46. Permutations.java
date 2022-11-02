class Solution {
    /*
     * 1 2 3 -> 1 3 2
     * 2 1 3 -> 2 3 1
     * 3 2 1 -> 3 1 2
     * 
     * 1 2 3
     * 3 2
     * 2 1 3
     * 3 1
     * 3 1 2
     * 2 1
     * If we exhausted the current branch, currResult.size() == nums.length, we will
     * backtrack.
     * To make sure each element is used once, we establish boolean[] used.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        backtrack(ans, new ArrayList<>(), nums);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) { // element already exists, skip
                    continue;
                }
                temp.add(nums[i]);
                backtrack(ans, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}