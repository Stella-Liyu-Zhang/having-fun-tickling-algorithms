**Table of contents**

- [7. Reverse Integer](#7-reverse-integer)
- [234. Palindrome Linked List](#234-palindrome-linked-list)
- [36. Valid Sudoku](#36-valid-sudoku)
  - [Approach 1: Use 1 hashset](#approach-1-use-1-hashset)
- [1300. Sum of Mutated Array Closest to Target](#1300-sum-of-mutated-array-closest-to-target)
- [692. Top K Frequent Words](#692-top-k-frequent-words)
  - [Approach 1: Priority Queue Heap](#approach-1-priority-queue-heap)
- [1328. Break a Palindrome](#1328-break-a-palindrome)
  - [Approach 1: Greedy Algo](#approach-1-greedy-algo)
- [62. Unique Paths](#62-unique-paths)
  - [Approach 1: Dynamic Programming](#approach-1-dynamic-programming)
  - [Approach 2: Memoization](#approach-2-memoization)
- [91. Decode Ways](#91-decode-ways)
  - [Approach 1: DP](#approach-1-dp)
- [49. Group Anagrams](#49-group-anagrams)
  - [Approach 1: HashTable](#approach-1-hashtable)
  - [Approach 2: Frequency array](#approach-2-frequency-array)
  - [Approach 1:](#approach-1)
  - [Approach 1:](#approach-1-1)
  - [Approach 1:](#approach-1-2)
  - [Approach 1:](#approach-1-3)
  - [Approach 1:](#approach-1-4)
  - [Approach 1:](#approach-1-5)
  - [Approach 1:](#approach-1-6)
  - [Approach 1:](#approach-1-7)

## 7. Reverse Integer

- Time: O(N), perform the modulo and division of all the element
- Space: O(1)
  > Basic steps:
  >
  > - First, we get the last digit remainder through modulo 10
  > - Then, we make the result \*10, then plus the remainder
  > - Next, we check if the result is out of bounds, if not,
  > - We divide x by 10 to get rid of the last digit, and then continue to proceed the rest.

```java
class Solution {
    public int reverse(int x) {
        long result = 0;
        while (x != 0){
            int remainder = x%10; //get the last digit
            result = result*10 + remainder;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
            x = x/10;
        }
        return (int) result;

    }
}
```

## 234. Palindrome Linked List

## 36. Valid Sudoku

### Approach 1: Use 1 hashset

- check each time if we are able to add it. if not, return false.
- Time: O(81) = O(1)
- Space: O(n), where n is number of non-empty elements in the soduku

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for(int i = 0; i <9; i ++){
            for(int j = 0; j <9; j++){
                if (board[i][j] != '.'){
                    if (!seen.add(board[i][j] + "in row" + i) ||
                        !seen.add(board[i][j] + "in col" + j) ||
                        !seen.add(board[i][j] + "in grid" + i/3 + "-" + j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

```

## 1300. Sum of Mutated Array Closest to Target

> Low ends up becoming is the minimum value that satisfies sum(arr,mid) >= target.
>
> - This means that the two best choices are either low or low - 1, where
>   - low is the closest value that gets you a sum greater than or equal to the target
>   - low - 1 is the closest value that gets you a sum less than the target.
> - Then, all you have to do is see which calculated sum is closest to the target.

- Time:
- Space:

```java

```

## 692. Top K Frequent Words

### Approach 1: Priority Queue Heap

What structure is perfect for maintaining an order as we are adding and removing elements? priority queue!

```
Min heap, max heap
["i","love","leetcode","i","love","coding"]
i = 2
love = 2
leetcode = 1
coding = 1
---> order by alphabetic orders:
Priority Queue: i love

---> only k elements, removing the element with greater alphatic order or less frequency
O(n log K): Insertion has worst case of O(log n)
O(n) * O(logK)
Loop through the word   insertion
```

```java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap();
        for(int i = 0; i < words.length; i ++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue(new Comparator<String>(){
            @Override
            public int compare(String word1, String word2){
                int frequency1 = map.get(word1);
                int frequency2 = map.get(word2);
                if(frequency1 == frequency2) return word2.compareTo(word1);
                else return frequency1 - frequency2;
            }
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.add(entry.getKey());
            if(pq.size() > k) pq.poll();
        }
        List<String> output = new ArrayList<>();
        while(!pq.isEmpty() ){
            output.add(pq.poll());
        }
        Collections.reverse(output);
        return output;

    }
}
```

## 1328. Break a Palindrome

### Approach 1: Greedy Algo

> - Check half of the string,

    replace a non 'a' character to 'a'.

- If only one character, return empty string.
  Otherwise repalce the last character to 'b'

- Time complexity: O(n/2)
- Space complexity: O(n)
  (if n is the length of string)

```java
public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        StringBuilder ans = new StringBuilder(palindrome);
        // no way to replace a character to make it not a palindrome
        if(len == 0 || len == 1) return "";
        for(int i = 0; i < len/2; i++){
            if(palindrome.charAt(i) != 'a'){
               ans.setCharAt(i, 'a');
               return ans.toString();
            }
        }
        ans.setCharAt(len-1, 'b');
        return ans.toString();
    }
```

## 62. Unique Paths

### Approach 1: Dynamic Programming

> dp[i][j] = dp[i-1][j] + dp[i][j-1];

- Time complexity: O(m\*n)
- Space complexity: O(m\*n)

```java
 public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
```

### Approach 2: Memoization

- Time complexity: O(m\*n)
- Space complexity: O(m\*n)

```java
class Solution {
    private Map<String, Integer> map = new HashMap<String, Integer>();
    public int uniquePaths(int m, int n) {
        //base case
        if (m == 1 || n == 1) return 1;
        // check if we have already calculated unique paths for cell(m, n)
        String cell = new String(m + "," + n);
        // if yes, then get its value from our memoization table
        if (map.containsKey(cell)) return map.get(cell);
        // else, explore the down move
        int downMove = uniquePaths(m-1, n);
        // explore the right move
        int rightMove = uniquePaths(m, n-1);

        //put the value obtained for unique paths from cell(m,n)
        map.put(cell, downMove + rightMove);
        return downMove + rightMove;
    }
}
```

## 91. Decode Ways

### Approach 1: DP

> determine how many ways, use all the subproblems up to solve the nth problem
> dp[i] will store the number of ways to decode s.

- Time complexity: O(n)
- Space complexity: O(n)

```java
        int ans = 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;
        for(int i = 2; i <= s.length(); i ++){
            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            int twoDigit = Integer.valueOf(s.substring(i-2,i));
            if (oneDigit > 0 && oneDigit < 10){
                dp[i] += dp[i-1];
            }
            if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
```

## 49. Group Anagrams

### Approach 1: HashTable

- First, we design a hashmap with
  - Key: the sorted string
  - Value: the list of values that are anagram with the sorted string
- Then we loop through the strs array
  - make the current string to be an array of character, sort it, and make it back to a string
  - check if the map contains the sorted string
    - if not contain, we will add am empty arraylist corresponding to the key
  - Then, we add the current into the corresponding list of array
- Ultimately, we add all the values into the list, and return it.

- Time complexity:`O(nmlogm)`
  - n is the total number of words and m is the length of each word.
- Space: `O(n)`

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList();
        if (strs.length == 0) return list;
        //key: sorted string
        //value: the list of anagram strings
        HashMap<String, List<String>> map = new HashMap();
        for(String curr: strs){
            char[] c = curr.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if (!map.containsKey(sorted)){
                map.put(sorted, new ArrayList());
            }
            //add the current word to the arraylist
            map.get(sorted).add(curr);
        }
        list.addAll(map.values());
        return list;
    }
}
```

### Approach 2: Frequency array

- Time complexity is `O(m*n)` or O( sum of all chars in strs). Use char[26] as bucket to count the frequency instead of Arrays.sort, this can reduce the O(nlgn) to O(n) when calculate the key.
- Space: O(n)

```java
public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] frequencyArr = new char[26];
            for(int i = 0;i<s.length();i++){
                frequencyArr[s.charAt(i) - 'a']++;
            }
            String key = new String(frequencyArr);
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key,tempList);
        }
        return new LinkedList<>(map.values());
    }
```

##

### Approach 1:

>

- Time complexity:
- Space complexity:
-

```java

```

##

### Approach 1:

>

- Time complexity:
- Space complexity:
-

```java

```

##

### Approach 1:

>

- Time complexity:
- Space complexity:
-

```java

```

##

### Approach 1:

>

- Time complexity:
- Space complexity:
-

```java

```

##

### Approach 1:

>

- Time complexity:
- Space complexity:
-

```java

```

##

### Approach 1:

>

- Time complexity:
- Space complexity:
-

```java

```

##

### Approach 1:

>

- Time complexity:
- Space complexity:
-

```java

```

##

### Approach 1:

>

- Time complexity:
- Space complexity:
-

```java

```
