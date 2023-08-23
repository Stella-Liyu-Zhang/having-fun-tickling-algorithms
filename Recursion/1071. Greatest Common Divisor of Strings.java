class Solution {
    /*
    Assume that the length of str2 will always be shorter than the length of str1
    assume str2 to be the shorter string
    check if str1 starts with str2 recursively

    Time: O(max(L1,L2))
    Space: O(Max(L1,L2)), in order to maintain the recursion stack
    */
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length() < str2.length()){
            return gcdOfStrings(str2, str1);
        }
        if (str2.equals(str1)){
            return str1;
        }
        if(str1.length() > str2.length() && str1.startsWith(str2)){
            return gcdOfStrings(str1.substring(str2.length(), str1.length()), str2);
        }
        return "";
    }
}