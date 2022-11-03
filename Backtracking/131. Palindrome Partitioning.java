class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList(), s, 0);
        return list;
    }

    public void backtrack(List<List<String>> list, List<String> temp, String s, int start) {
        if (start == s.length()) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    temp.add(s.substring(start, i + 1));
                    backtrack(list, temp, s, i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}