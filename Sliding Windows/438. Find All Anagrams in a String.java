class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (s.length() == 0 || s== null){
            return ans;
        }

        //ascci values frequency table
        int[] table = new int[26];
        for(char c: p.toCharArray()){
            table[c - 'a'] ++;
        }
        //sliding windows approach
        //boundaries left and right
        int left = 0;
        int right = 0;
        int diff = p.length();
        /*
         * Each time we update the size, and 
         when size == 0, we add into ans
         diff = length of currently found anagram. If it equals the length of anagram to find, it must have been found

         find an anagram, expand the right boundary
         then move the left boundary
         */
        while (right < s.length()){
            char temp = s.charAt(right);
            if (table[s.charAt(right ++) - 'a'] -- >= 1){ //such a character exists, part of anagram
                diff --;
            }
            if (diff == 0){ //find the whole anagram
                ans.add(left);//add the starting index
            }
            if (right - left == p.length() && table[s.charAt(left ++ ) - 'a'] ++ >= 0){//the window expands to the size of the anagram
                // left ++; //move the left boundary
                // table[temp - 'a'] ++;
                //increment diff
                diff ++;
            }
        }
        return ans;
    }
}