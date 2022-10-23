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
