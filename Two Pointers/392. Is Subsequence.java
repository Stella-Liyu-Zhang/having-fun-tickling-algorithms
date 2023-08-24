class Solution {
    /*
    If source[left] == target[right]: we found a match. Hence, we move both pointers one step forward.
    If source[left] != target[right]: no match is found. We then move only the right pointer on the target string.
    Time: O(t.length)
    space: O(1)
    */
    public boolean isSubsequence(String s, String t) {
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1 < s.length() && ptr2 < t.length()){
            if (s.charAt(ptr1) == t.charAt(ptr2)){
                ptr1 ++;
            }
            ptr2 ++;
        }
        return ptr1 == s.length();
    }
}