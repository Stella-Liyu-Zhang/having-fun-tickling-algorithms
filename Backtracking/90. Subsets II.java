public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList();
    Arrays.sort(nums);
    backtrack(list, nums, new ArrayList<>(), 0);
    return list;
}
public void backtrack(List<List<Integer>> list, int[] nums, List<Integer> temp, int start){
    list.add(new ArrayList<>(temp));
    for(int i = start; i < nums.length; i ++){
        if (i > start && nums[i] == nums[i-1]) continue;
        temp.add(nums[i]);
        backtrack(list, nums, temp, i + 1);
        temp.remove(temp.size() - 1);
    }
}