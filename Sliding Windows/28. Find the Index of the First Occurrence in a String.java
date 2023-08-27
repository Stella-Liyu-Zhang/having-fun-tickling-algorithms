class Solution {
    /*
    hlength - nlength

    */
    public int strStr(String haystack, String needle) {
        int hlength = haystack.length();
        int nlength = needle.length();
        for(int windowStart = 0; windowStart <= hlength - nlength; windowStart ++){
            for(int j = 0; j < nlength; j++){
                if(haystack.charAt(windowStart + j) != needle.charAt(j)){
                    break;
                }
                if(j == nlength - 1){
                    return windowStart;
                }
            }
        }
        return -1;
    }
}