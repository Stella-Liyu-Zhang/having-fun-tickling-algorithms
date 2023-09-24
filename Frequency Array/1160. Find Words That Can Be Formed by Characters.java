class Solution {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        int[] freq = new int[26];
        for(char c: chars.toCharArray()){
            freq[c - 'a'] ++;
        }
        for(String word: words){
            int[] currSeen = Arrays.copyOf(freq, freq.length);
            int currCount = 0;
            for(char c: word.toCharArray()){
                if(currSeen[c-'a'] > 0){
                    currSeen[c-'a'] --;
                    currCount ++;
                }
            }
            if(currCount == word.length()){
                sum += currCount;
            }

        }
        return sum;
    }
}