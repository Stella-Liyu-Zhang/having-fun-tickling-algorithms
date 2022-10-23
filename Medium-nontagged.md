# Table of contents

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

##

第一个 实现字典 insert, get, addnum2Allkey and addnum2allValue
思路：利用 offset，不需要每次都加到 key 或者 value 上，只在 insert 和 get 的之后加上 offset

```java
public static class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;
        public  Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    public static long hashMap(String[] queryType, int[][] query) {
        long getRes = 0;
        if (queryType.length == 0) return getRes;
        Node head = new Node(0,0), tail = head;
        Set<Integer> set = new HashSet();
        for (int i = 0; i < queryType.length; i++) {
            if (queryType.equals("insert")) {
                int k = query[0], v = query[1];
                if (set.contains(k)) {
                    Node temp = head.next;
                    while (temp != null && temp.key != k) {
                        temp = temp.next;
                    }
                    temp.value += v;
                } else {
                    Node newOne = new Node(k, v);
                    tail.next = newOne;
                    newOne.prev = tail;
                    tail = tail.next;
                    set.add(k);
                }
            } else if (queryType.equals("addToValue")) {
                int v = query[0];
                Node temp = head.next;
                while (temp != null) {
                    temp.value += v;
                    temp = temp.next;
                }
            } else if (queryType.equals("addToKey")) {
                int k = query[0];
                Node temp = head.next;
                while (temp != null) {
                    set.remove(temp.key);
                    temp.key += k;‍‍‌‍‌‌‍‍‌‍‌‍‌‌‍‌‌‍‌‌
                    if (!set.contains(temp.key)) set.add(temp.key);
                    temp = temp.next;
                }
            } else if (queryType.equals("get")) {
                int k = query[0];
                Node temp = head.next;
                while (temp != null && temp.key != k) {
                    temp = temp.next;
                }
                getRes += temp.value;
            }
        }
        return getRes;
    }

```

```java
long hashMap(String[] queryType, int[][] query) {

       long sum = 0;

       Integer currKey = 0;

       Integer currValue = 0;

       Map<Integer, Integer> values = new HashMap<>();

       for (int i = 0; i < queryType.length; i++) {

           String currQuery = queryType[i];

           switch (currQuery) {

           case "insert":

               HashMap<Integer, Integer> copiedValues = new HashMap<>();

               if (currKey != 0 || currValue != 0) {

                   Set<Integer> keys = values.keySet();

                   for (Integer key : keys) {

                       copiedValues.put(key + currKey, values.get(key) + currValue);

                   }

                   values.clear();

                   values.putAll(copiedValues);

                   currValue = 0;

                   currKey = 0;

               }

               values.put(query[i][0], query[i][1]);

               break;

           case "addToValue":

               currValue += values.isEmpty() ? 0 : query[i][0];

               break;

           case "addToKey":

               currKey += values.isEmpty() ? 0 : query[i][0];

               break;

           case "get":

               copiedValues = new HashMap<>();

               if (currKey != 0 || currValue != 0) {

                   Set<Integer> keys = values.keySet();

                   for (Integer key : keys) {

                       copiedValues.put(key + currKey, values.get(key) + currValue);

                   }

                   values.clear();

                   values.putAll(copiedValues);

                   currValue = 0;

                   currKey = 0;

               }

               sum += values.get(query[i][0]);

           }

       }

       return sum;

   }
```

```java
long solution(String[] queryType, int[][] query) {
  int curKeyInc = 0;
  int curValInc = 0:
  HashMap<Integer, Integer> mp = new HashMaps<>():
  long ans = 0;
  for (int i = 0; i < queryType.length; i++) {
    if (queryType[i].equals("insert")) {
      mp.put(query[i][0] - curKeyInc, query[i][1] - curValInc);
    } else if (queryType[i].equals("addToValue")) {
      curValInc += query[i][0];
    } else if (queryType[i].equals("addToKey")) {
      curKeyInc += query[i][0];
    } else {
      ans += mp.getOrDefault(query[i][0] - curkeyInc, -1 * curValInc) + curValInc;
    }
    return ans;
  }
}
```
