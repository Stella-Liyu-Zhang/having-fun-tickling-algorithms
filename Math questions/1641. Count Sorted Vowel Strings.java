class Solution {
    /*
    5 = 5
    15 = 5+4+3+2+1
    (5 n) = (n+4)*(n+3)*(n+2)*(n+1)/24


    */
    public int countVowelStrings(int n) {
        return (n+4)*(n+3)*(n+2)*(n+1)/24;
    }
}