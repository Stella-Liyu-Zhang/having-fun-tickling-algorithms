## Why Company

Tech stacks: C#, Orleans, RabbitMQ

- Working in the Simulacra team to redesign the distributed system to make the software more scalable.
- Restructuring the in-memory data management system for faster querying and lighter memory usage.
- Optimizing clustering algorithms for the “rendering physical items on the map” feature to run 1000x faster.

## Resume Walkthrough

### Coursework: dropped operating systems, it was supposed to be taken in FA22

## Problem 1:

1.  When building the palindrome, you can rearrange the remaining letters in
    any way.

- Time: O(Max between n and 26)
- Space: O(unique chars in the str)

> algo walkthrough:
>
> - Make a frequency table of size 26, where each frequency[i] will be storing the occurence of the ith character in the string
> - Loop through the string, make the frequency table
> - loop through the frequency table (0 to 25), count number of characters with odd frequency
> - because in a palindrome, we could only allow 0 or 1 character with odd frequency:
>   - eg. aabaa has 1 character with odd frequency
>   - eg. aabbaa has 0 character with odd frequency
>   - eg. aabaac cannot be come a palindrome
> - any string with >= 2 odd frequency characters CANNOT form a palindrome!!!
> - Therefore, we will return 0 if count == 0 or count == 1
> - Otherwise, we will be returning count - 1.
>   - at this stage, we either return count or count - 1 would ACHIEVE OUR GOAL!
>   - Since we are looking for the MINIMUM number of characters to be removed from the original string,
>   - we return count - 1, since it's smaller than count.

```java
class Solution {
    public int solution(String S) {
        //minimum number to be removed in order to build a palindrome
        int n = S.length();
        int[] frequency = new int[26];
        for(int i = 0; i < n; i ++){
            frequency[s.CharAt(i) - 'a'] ++;
        }
        //count the number of characters with odd frequency
        int count = 0;
        for(int i = 0; i < 26; i ++){
            if (frequency[i] %2 == 1){
                count ++;
            }
        }
        if (count == 0|| count == 1){
            return 0;
        }else{
            return count - 1;
        }
    }
}
```

## Problem 2

Given an array A consisting of strings, your function should calculate the length of the longest string S such that:

- S is a concatenation of some of the strings from A;
- every letter in S is different.

- Time: `O(n\*2^n)` N = number of elements in arr
-

```java
class Solution{
    private int output = 0;

    private int solution(String[] A){
        //check the edge cases:
        if (A == null || A.length == 0){
            return 0;
        }
        dfs(A, "", 0);
        return output;
    }

    private void dfs(String[] arr, String path, int index){
        boolean isUnique = uniquechars(path);
        if (isUnique){
            output = Math.max(path.length(), output);
        }
        if (index == arr.size() || !isUnique){
            return;
        }
        // for each string in arr
        for(int i = index; i < arr.size(); i ++){
            // try subsequent strings in arr
            dfs(arr,path+arr.get(i), i + 1);
        }
    }

    private boolean isUnique(String s){
        Set<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            if (set.contains(c)){
                return false;
            }else{
                set.add(c);
            }
        }
        return true;
    }
}

```

7, 10 20 30 70
