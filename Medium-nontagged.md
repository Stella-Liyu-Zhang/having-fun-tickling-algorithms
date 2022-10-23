**Table of contents**

- [7. Reverse Integer](#7-reverse-integer)
- [234. Palindrome Linked List](#234-palindrome-linked-list)
- [36. Valid Sudoku](#36-valid-sudoku)
  - [Approach 1: Use 1 hashset](#approach-1-use-1-hashset)

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
