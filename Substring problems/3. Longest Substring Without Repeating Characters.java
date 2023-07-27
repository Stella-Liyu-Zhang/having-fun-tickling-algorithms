class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int max = 0;
        HashSet<Character> set = new HashSet();//set of characters where each of them is unique in a substring
        while(right < s.length()){
            char c = s.charAt(right);
            while (set.contains(c)){
                set.remove(s.charAt(left));
                left ++;
            }
            set.add(c);
            max = Math.max(right-left + 1, max);
            right ++;
        }
        return max;
    }
}