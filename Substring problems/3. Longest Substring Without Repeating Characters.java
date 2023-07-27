class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int start = 0, end = 0;
        int maxLen = 0;
        int counter = 0;

        while(end < s.length()){ // Move end to find a valid window.
            char c1 = s.charAt(end);
            if (map[c1] > 0) { //if the end element is duplicate, count ++
                counter ++;
            }
            map[c1] ++;
            end ++; //move end to the next one
            while(counter > 0){
                char c2 = s.charAt(start); //get the start
                if(map[c2] > 1){ 
                    counter --;
                }
                map[c2] --;
                start ++;
            }
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }
}