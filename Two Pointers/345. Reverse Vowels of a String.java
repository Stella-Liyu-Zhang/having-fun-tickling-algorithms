class Solution {
    /*
    Time: O(n)
    Space: O(n)
    */
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(isVowel(arr[left]) && isVowel(arr[right])){
                swap(arr, left, right);
                left ++;
                right --;
            }else if (!isVowel(arr[left])){
                left ++;
            }else if (!isVowel(arr[right])){
                right --; 
            }
        }
        return new String(arr);
    }
    private void swap (char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private boolean isVowel (char c){
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}