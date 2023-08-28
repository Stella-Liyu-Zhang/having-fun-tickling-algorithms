class Solution {
    /*
    make an array of strings called mapping

    */
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        if (digits.length()==0) return ans;

        String[] map = {
            "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        backTrack(ans, digits, "", 0, map);
        return ans;

    }
    private void backTrack(List<String> ans, String digits, String curr, int index, String[] map){
        //stop the recursive call whenever we have a combination
        // and how to determine the combination is correct is by its length.
        //we would just return
        if(index == digits.length()){
            ans.add(curr);
            return;
        }
        String letters  = map[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i ++){
            backTrack(ans, digits, curr + letters.charAt(i), index + 1, map);
        }

    }
}