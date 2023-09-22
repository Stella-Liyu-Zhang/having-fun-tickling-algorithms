class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqArr = new int[26];
        for(char c: s.toCharArray()){
            freqArr[c-'a'] ++;
        }
        for(char c: t.toCharArray()){
            freqArr[c-'a'] --;
        }
        for(int i = 0; i < 26; i ++){
            if(freqArr[i] != 0){
                return false;
            }
        }
        return true;
    }
}