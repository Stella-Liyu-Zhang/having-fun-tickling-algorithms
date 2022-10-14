class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window algorithm
        // data: string, increment our data, looking at parts of data incremently

        // two pointers, both pointer start at beginning
        // PWWKEW
        // Set = [ P W ]
        // window length: i - j + 1 (1, 2)
        // substring P is the longest ---> update max to be the max of max and length of
        // P
        // hashset keeps track of unique characters in the window

        int a_pointer = 0, b_pointer = 0, max = 0;
        HashSet<Character> hs = new HashSet<>();

        while (b_pointer < s.length()) {
            if (!hs.contains(s.charAt(b_pointer))) {
                hs.add(s.charAt(b_pointer));
                max = Math.max(max, hs.size());
                b_pointer++;
            } else {
                hs.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return max;

    }
}