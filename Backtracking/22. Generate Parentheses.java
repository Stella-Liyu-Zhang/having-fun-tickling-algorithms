class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, "", 0, 0, n);
        return ans;
    }
    private void backTrack(List<String> result, String curr, int open, int close, int n){
        if(curr.length() == 2*n){
            result.add(curr);
            return;
        }
        if(open < n){
            backTrack(result, curr + "(", open + 1, close, n);
        }
        if(close < open){
            backTrack(result, curr + ")", open, close + 1, n);
        }
    }
}