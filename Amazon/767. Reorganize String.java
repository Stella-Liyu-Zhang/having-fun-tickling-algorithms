class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }
        int maxFreq = 0, indexofMax = 0;
        for(int i = 0; i < 26; i ++){
            if(freq[i] > maxFreq){
                maxFreq = freq[i];
                indexofMax = i;
            }
        }

        if(maxFreq > (s.length() + 1)/2) return "";
        char[] slots = new char[s.length()];
        //assign the maximum frequent element into the slots 
        int pointer = 0;

        while(freq[indexofMax] > 0){
            slots[pointer] = (char) ('a' + indexofMax);
            freq[indexofMax] --;
            pointer = pointer + 2;
        }

        //assign the rest
        for(int i = 0; i < freq.length; i ++){
            int currFreq = freq[i];
            while(currFreq > 0){
                 if(pointer >= s.length()){
                    pointer = 1;
                }
                slots[pointer] = (char) ('a' + i);
                pointer = pointer + 2;
                currFreq --;
            }
        }

        return String.valueOf(slots);

    }
}