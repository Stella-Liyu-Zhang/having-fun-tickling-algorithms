class Solution {
    public String reverseVowels(String s) {
        char[] sArray = s.toCharArray();
        int left = 0, right = sArray.length - 1;

        while (left < right) {
            if (isVowel(sArray[left]) && isVowel(sArray[right])) {
                swap(sArray, left, right);
                left++;
                right--;
            }
            if (!isVowel(sArray[left])) {
                left++;
            }
            if (!isVowel(sArray[right])) {
                right--;
            }
        }
        return new String(sArray);
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean isVowel(char ch) {
        char c = Character.toLowerCase(ch);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}