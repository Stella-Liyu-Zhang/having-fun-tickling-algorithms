class Solution {
    /*
    Frequency of each char
    Need to check the following:
    - every single letter in word 1 appears in word 2
    - All the frequencies do match!!
        - sort
        - then we could do operation 1
    - All the unique chars do exist in the other ones

    */
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for(char c: word1.toCharArray()){
            counts1[c-'a'] ++;
            set1.add(c);
        }
        for(char c: word2.toCharArray()){
            counts2[c-'a'] ++;
            set2.add(c);
        }
        Arrays.sort(counts1);
        Arrays.sort(counts2);
        return set1.equals(set2) && Arrays.equals(counts1, counts2);

    }
}