20. Valid Parentheses
    This problem is relatively simple

- build a stack
- turn the String into an array of characters using toCharArray()
- Since a pair of parentheses is (), whenever we see a left one, we push the right one into the stack
- After pushing each corresponding parentheses paired to the one came across,
  - check if the stack is empty or if the top ones doesn't match

## Monotonic Stack

## 496. Next Greater Element I

Brutal force approach: loop through nums1, and then nested loop through nums2
We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek() we pop all elements less than x and for all the popped ones, their next greater element is x
For example [9, 8, 7, 3, 2, 1, 6]

The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 so we pop 1 2 3 whose next greater element should be 6

> - Hashmap: Key: each number, Value: its next greatest element
> - loop through nums2,
>   - while stack is not empty, and the peek of stack is smaller than the current value
>   - we put the (stack.pop(), and the curr value) into our map.
>   - push the current value into the stack
> - and update the nums1 array with getordefault(), with not-found-value being outputed as 1.
>
> - Input:
>   nums1 = [4,1,2]
>   nums2 = [1,3,4,2]
>   stack=[1] > [1,3]
>   stack = [3] > [3,4]
>   stack = [4]

- Time complexity: O(nums length)
  - 对于每个元素 num 来说，在 for 循环当中会执行 3 steps: push, pop, and put。所以如果考虑 constant 的话 running time 是 O(3n)。
- Space complexity: O(n)

```java
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length; i ++){
            while(stack.isEmpty() == false && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(int j = 0; j < nums1.length; j ++){
            int curr = map.getOrDefault(nums1[j], -1);
            nums1[j] = curr;
        }
        return nums1;

    }
```
