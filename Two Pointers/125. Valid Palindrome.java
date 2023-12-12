class Solution {
    public boolean isPalindrome(String s) {
        //get rid of uppercase and non-alphanumeric characters
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}

//second attempt
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left ++;
                right --;
            }else{
                return false;
            }
            
        }
        return true;
    }
}
