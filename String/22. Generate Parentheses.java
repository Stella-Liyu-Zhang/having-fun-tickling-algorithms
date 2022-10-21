class Solution {
    public List<String> generateParenthesis(int n) {
        // ()()() - n () concatinated together
        // () independent
        // 2 independent
        // 3 independent
        // backtracking
        List<String> ans = new ArrayList<>();
        backtrack(ans, n, 0, 0, "");
        return ans;
    }

    public void backtrack(List<String> ans, int max, int open, int closed, String s) {
        if (max * 2 == s.length()) {
            ans.add(s);

        }
        if (open < max) {
            backtrack(ans, max, open + 1, closed, s + "(");
        }
        if (closed < open) {
            backtrack(ans, max, open, closed + 1, s + ")");
        }
    }
}