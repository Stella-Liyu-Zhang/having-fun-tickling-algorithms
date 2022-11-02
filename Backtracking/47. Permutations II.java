public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(ans, new ArrayList<>(), nums, new boolean[nums.length]);
    return ans;

}
public void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] used){
    if (temp.size() == nums.length){
        ans.add(new ArrayList<>(temp));
    }else{
        for(int i = 0; i < nums.length; i++){
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1] ) continue;
            used[i] = true;
            temp.add(nums[i]);
            backtrack(ans, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}