class Solution {
    /*
     * Check half of the string,
     * replace a non 'a' character to 'a'.
     * 
     * If only one character, return empty string.
     * Otherwise repalce the last character to 'b'
     * 
     */
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        StringBuilder ans = new StringBuilder(palindrome);
        // no way to replace a character to make it not a palindrome
        if (len == 0 || len == 1)
            return "";
        for (int i = 0; i < len / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                ans.setCharAt(i, 'a');
                return ans.toString();
            }
        }
        ans.setCharAt(len - 1, 'b');
        return ans.toString();
    }
}