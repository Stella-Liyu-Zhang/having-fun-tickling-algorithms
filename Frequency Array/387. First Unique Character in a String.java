class Solution {
    /*
    Create a freq Array of 26 length

    find the first index which has 1

    */
    public int firstUniqChar(String s) {
        int[] freqArr = new int[26];
        for(char c: s.toCharArray()){
            freqArr[c-'a'] ++;
        }
        for(int i = 0; i < s.length(); i ++){
            if(freqArr[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}

//second attempt
class Solution {
    public int firstUniqChar(String s) {
        int[] charArr = new int[26];
        for(char c: s.toCharArray()){
            charArr[c - 'a'] ++;
        }
        for(int i = 0; i < s.length(); i ++){
            if(charArr[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}