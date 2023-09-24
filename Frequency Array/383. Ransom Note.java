class Solution {
    /*
    Build a freq array out of magaazine
    delete each time we come across in ransomNote
    
    check if negative, if so, return false
    */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freqArr = new int[26];
        for(char c: magazine.toCharArray()){
            freqArr[c-'a'] ++;
        }
        for(char c: ransomNote.toCharArray()){
            freqArr[c-'a'] --;
        }
        for(int i = 0; i < freqArr.length; i ++){
            if (freqArr[i] < 0){
                return false;
            }
        }
        return true;
    }
}