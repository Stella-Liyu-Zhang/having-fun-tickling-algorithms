class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list, k, n, 1, new ArrayList<>());
        return list;
    }
    private void backTrack(List<List<Integer>> list, int k, int n, int index, List<Integer> curr){
        if(curr.size() == k && n == 0){
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i <= 9; i ++){
            curr.add(i);
            backTrack(list, k, n-i, i+1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}