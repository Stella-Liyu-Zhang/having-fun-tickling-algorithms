class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int ap = 0, bp = s.length() - 1;
        while (ap < bp) {
            if (s.charAt(ap) != s.charAt(bp)) {
                return false;
            }
            ap++;
            bp--;
        }
        return true;
    }
}