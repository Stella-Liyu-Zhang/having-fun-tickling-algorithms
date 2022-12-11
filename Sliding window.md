```
1. Use two pointers: start and end to represent a window.
2. Move end to find a valid window.
3. When a valid window is found, move start to find a smaller window.
```

To check if a window is valid, we use a map to store (char, count) for chars in t. And use counter for the number of chars of t to be found in s. The key part is m[s[end]]--;. We decrease count for each char in s. If it does not exist in t, the count will be negative.

## 3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

```
Input: s = "abcabcbbd"
Output: 3

Explanation: The answer is "abc", with the length of 3.
Input: s = "bbbbb"
Output: 1

Explanation: The answer is "b", with the length of 1.
Input: s = "pwwkew"
Output: 3

// abcab
window:   c a b
2
4
longest: 3
```

```java
int a_pointer = 0, b_pointer = 0, max = 0;
HashSet<Character> hs = new HashSet<>();

        while (b_pointer < s.length()){
            if (!hs.contains(s.charAt(b_pointer))){
                hs.add(s.charAt(b_pointer));
                max = Math.max(max, hs.size());
                b_pointer ++;
            }else{
                hs.remove(s.charAt(a_pointer));
                a_pointer ++;
            }
        }
        return max;
```

### 438. Find All Anagrams in a String

- Time complextiy: O(n)

```java
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
```
