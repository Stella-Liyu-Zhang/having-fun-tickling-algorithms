class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = s.length() - 1;
        while(left <= right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar != rightChar){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}