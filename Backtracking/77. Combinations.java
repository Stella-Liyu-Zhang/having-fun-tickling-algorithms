class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList();
        backtrack(n, k, new ArrayList<>(), list, 1);
        return list;
    }

    public void backtrack(int n, int size, List<Integer> temp, List<List<Integer>> list, int start) {
        if (size == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrack(n, size - 1, temp, list, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}