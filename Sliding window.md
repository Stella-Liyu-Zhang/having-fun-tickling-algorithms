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
