class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        //try to see the difference be
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < str1.length() && ptr2 < str2.length()){
            char char1 = str1.charAt(ptr1);
            char char2 = str2.charAt(ptr2);
            /*
                abc
                ad
            */
            if(char1 < char2 ){
                if(Math.abs(char1 - char2) > 1){
                    ptr1 ++;
                }else{
                    ptr1++;
                    ptr2++;
                }
            }else if (char1 == char2){
                ptr1 ++;
                ptr2 ++;
            }else{//char1 > char2
                int diff = char2 - char1;
                if(diff < 0) diff += 26;
                if(diff == 1){
                    ptr1 ++;
                    ptr2 ++;
                }else{
                    ptr1 ++;
                }
                
            }
        }
        return ptr2 == str2.length();
    }
}