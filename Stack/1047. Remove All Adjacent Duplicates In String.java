class Solution {
    public String removeDuplicates(String s) {
        // Use stack st to store non duplicate characters so far.
        // Iterating each character c in string s, if the the top of stack is equal to c
        // then st.pop() else st.append(c).
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == c) {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }

}