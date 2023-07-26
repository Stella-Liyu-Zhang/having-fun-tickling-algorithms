class Solution {
    /*
    1. Use two pointers: start and end to represent a window.
    2. Move end to find a valid window.
    3. When a valid window is found, move start to find a smaller window.
    */
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for(char c: t.toCharArray()){
            map[c] ++;
        }
        int start = 0, end = 0;
        int counter = t.length(); //check whether the substring is valid
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            if(map[c] > 0){
                counter --;
            }
            map[c] --;
            end ++;
            while(counter == 0){ //the substring is valid
                if(minLen > end-start){
                    minStart = start;
                    minLen = end - start;
                }
                char c2 = s.charAt(start); //move start to find a smaller window.
                map[c2] ++;
                if (map[c2] > 0){
                    counter ++;
                }
                start ++;
            }
            
        }

        return minLen == Integer.MAX_VALUE?"" : s.substring(minStart, minStart + minLen);
    }
}