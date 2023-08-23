class Solution {
    /*
    Time: O(m+n)
    Space: O(1)
    */
    public String mergeAlternately(String word1, String word2) {
        int ptr1 = 0, ptr2 = 0;
        StringBuilder sb = new StringBuilder();

        while(ptr1 < word1.length() && ptr2 < word2.length()){
            sb.append(word1.charAt(ptr1));
            sb.append(word2.charAt(ptr2));
            ptr1++;
            ptr2++;
        }
        //Important thing to note: substring should start at ptr1, since we increment the pointer earlier, but have not yet append it.
        if(ptr1 != word1.length()){
            sb.append(word1.substring(ptr1,word1.length()));
        }else if (ptr2 != word2.length()){
            sb.append(word2.substring(ptr2, word2.length()));
        }
        return sb.toString();
    }
}