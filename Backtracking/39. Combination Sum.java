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
            for(int i = start; i < candidates.length; i ++){
                temp.add(candidates[i]);
                backtrack(lists, temp, candidates, i, remain-candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
} 