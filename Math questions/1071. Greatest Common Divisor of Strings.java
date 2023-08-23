class Solution {
    /*
    Time compexity: O(log(min(n1,n2)))
    Space compexity: O(min(n1, n2))
    */
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2+str1)){
            return "";
        }
        int gcdVal = getGCD(str1.length(), str2.length());
        return str1.substring(0, gcdVal);
    }
    private int getGCD(int l1, int l2){
        if (l2 == 0){
            return l1;
        }else{
            return getGCD(l2, l1 % l2);
        }
    }
}