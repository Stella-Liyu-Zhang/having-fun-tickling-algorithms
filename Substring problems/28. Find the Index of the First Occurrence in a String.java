class Solution {
    /*
    hlength - nlength

    */
    public int strStr(String haystack, String needle) {
        int hlength = haystack.length();
        int nlength = needle.length();
        for(int start = 0; start <= hlength - nlength; start++){
            for(int j = 0; j < nlength; j++){
                if(haystack.charAt(start+j) != needle.charAt(j)){
                    break;
                }
                if(j == nlength - 1){
                    return start;
                }
            }
        }
        return -1;
    }
}

