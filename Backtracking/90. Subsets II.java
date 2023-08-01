class Solution {
    /*
    Find the power set (all possible subsets) excluding duplicate subsets. a total of 2^n distinct subsets for an array of length n with no duplicates.

    */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new  ArrayList<>();
        subsetHelper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    //generate all the susets
    private void subsetHelper(List<List<Integer>> subsets, List<Integer> curr, int[] nums, int start){
        subsets.add(new ArrayList<>(curr));

        for(int i = start; i < nums.length; i ++){
            //If the current element is a duplicate, ignore
            if (i != start && nums[i] == nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            subsetHelper(subsets, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}