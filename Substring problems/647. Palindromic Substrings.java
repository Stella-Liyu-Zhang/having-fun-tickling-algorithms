class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        if (s.length() == 0){
            return 0;
        }
        for(int i = 0; i < s.length() - 1; i ++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return count + 1;
    }
    private void extendPalindrome (String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count ++;
            left --;
            right ++;
        }
    }
}