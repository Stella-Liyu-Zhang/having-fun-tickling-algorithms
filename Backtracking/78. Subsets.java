class Solution {
    /*
     * Simulating, non-simulating each number
     * recursively,
     * - space O(n), as the stack goes, the deepest of the stack could go would be
     * the size of nums.
     * - run time O(2^n), n is size of nums.
     * the recursive call where you have index+1 should be i+1; Otherwise there
     * would be duplicates.
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerset = new ArrayList<>();
        backtrack(nums, powerset, 0, new ArrayList<Integer>());
        return powerset;
    }
    // generate the powerset of the subset
    /*
     * take the index of first element to add
     * current combination
     */
    public void backtrack(int[] nums, List<List<Integer>> powerset, int index, List<Integer> curr) {
        powerset.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, powerset, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}