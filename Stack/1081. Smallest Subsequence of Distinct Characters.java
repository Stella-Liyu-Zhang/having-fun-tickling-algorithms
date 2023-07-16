/**
 * 
 * First Of all, we have to pick the character's if it is not already visited.
 * If, that's the case we'll try to pick these character's. We'll also make
 * sure, the previously picked character is smaller then the current character
 * in order to maintain lexicographically order. But, how we can check the
 * previously picked character is best for!! And the answer is Stack!!
 * 
 * 
 * - If the stack is empty, we'll put the current character into our stack
 * - We'll also keep here boolean array which will mark, whether we have seen
 * this character or not. So, that if we are getting again the same character
 * and we have already seen that. We'll ignore that character.
 * - So, the length of boolean array will be 26
 * 
 * cbacdcbc
 * 
 * Time complexity is O(26N), as the the size of stack won't exceed 26. It can
 * be improved by using one more hashmap. I did this in Java.
 * 
 * Space complexity is O(26)
 **/

class Solution {
    public String smallestSubsequence(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int[] occur = new int[26]; // contain number of occurences of character (i+'a')
        boolean[] seen = new boolean[26]; // will contain if character (i+'a') is present in current result Stack

        for (char c : ch) {
            occur[c - 'a']++;
        }
        int index = 0;
        for (Character c : s.toCharArray()) {
            index = c - 'a';
            occur[index]--; // decrement number of characters remaining in the string to be analysed
            if (seen[index]) {
                continue;
            }
            // if current character is smaller than last character in stack which occurs
            // later in the string again
            // it can be removed and added later e.g stack = bc remaining string abc then a
            // can pop b and then c
            while (!stack.isEmpty() && c < stack.peek() && occur[stack.peek() - 'a'] != 0) {
                seen[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            seen[index] = true;
        }
        StringBuilder sb = new StringBuilder();
        // pop character from stack and build answer string from back
        while (stack.isEmpty() == false) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}