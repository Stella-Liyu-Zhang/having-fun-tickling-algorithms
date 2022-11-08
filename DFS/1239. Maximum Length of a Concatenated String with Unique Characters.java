class Solution {
    private int result = 0;

    public int maxLength(List<String> arr) {
        // check edge case
        if (arr == null || arr.size() == 0)
            return 0;
        dfs(arr, "", 0);
        return result;
    }

    private void dfs(List<String> arr, String path, int index) {
        if (isUniqueChars(path)) {
            result = Math.max(path.length(), result);
        }
        if (index == arr.size() || isUniqueChars(path) == false) {
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }
    }

    private boolean isUniqueChars(String str) {
        Set<Character> set = new HashSet();
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}