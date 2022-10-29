class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] one = new int[26];
        int[] two = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            one[word1.charAt(i) - 'a']++;
            two[word2.charAt(i) - 'a']++;
        }
        for (int j = 0; j < 26; j++) {
            if (Math.abs(one[j] - two[j]) > 3) {
                return false;
            }
        }
        return true;
    }
}