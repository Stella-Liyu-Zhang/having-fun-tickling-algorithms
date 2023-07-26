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

        So, while it seems weird to remove elements from the temp array after getting [1,2,3]
         (which leaves you with [1,2]), it starts to make a lot of sense when you go back   
         another level on the recursion and reduce [1,2] to [1], and now you are able to make it [1,3] with your for loop, allowing for full permutation.

         this is the gist of backtracking. Restore state and let upper level of recursion to continue 
         visit this element。
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