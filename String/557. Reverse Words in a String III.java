class Solution {
    public String reverseWords(String s) {
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length; i ++){
            if(charArr[i] != ' '){ // while i is not a space
                int j = i;
                while(j+1 < charArr.length && charArr[j+1] != ' '){ //move j to the end of the word
                    j++;
                }
                reverse(charArr, i, j);
                i = j;
            }
        }
        return new String(charArr);
    }
    private void reverse(char[] charArr, int start, int end){
        while(start < end){
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }
    }
}