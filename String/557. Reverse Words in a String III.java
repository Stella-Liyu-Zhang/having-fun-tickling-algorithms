class Solution {
    public String reverseWords(String s) {
        int i = 0, j = 0;
        char[] charArr = s.toCharArray();
        while(j < charArr.length){
            if(charArr[j] != ' '){
                while(j != charArr.length - 1 && charArr[j+1] != ' '){
                    j++;
                }
                reverse(charArr, i, j);
                j = j+2;
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