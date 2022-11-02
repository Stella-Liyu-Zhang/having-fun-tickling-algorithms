class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, candidates, target, 0, new ArrayList<>());
        return ans;

    }

    public void backtrack(List<List<Integer>> ans, int[] candidates, int remain, int start, List<Integer> temp) {
        if (remain < 0)
            return;
        else if (remain == 0) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < candidates.length; i++) { // note that should always start from start!!!! or there
                                                              // will be duplicated stuff like [2,2,3], [3,2,2]
                temp.add(candidates[i]);
                backtrack(ans, candidates, remain - candidates[i], i, temp); // we don't start from i + 1, since it
                                                                             // could be duplicate/reused
                temp.remove(temp.size() - 1);
            }
        }
    }
}