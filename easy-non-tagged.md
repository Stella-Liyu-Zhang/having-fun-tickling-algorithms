## 112. Path Sum

sum: represents the remaining path sum from current node to leaf node before the current node is taken into consideration. That's why for the leaf node, we
need to do sum - root.val == 0

> If there are n nodes in binary tree, maximum height of the binary tree is `n-1` and minimum height is `floor(log_2(n))`.
>
> For example, left skewed binary tree shown in Figure 1(a) with 5 nodes has height 5-1 = 4 and binary tree shown in Figure 1(b) with 5 nodes has height floor(log(25)) = 2.

- time: `O(n)`
- Space: height of the tree.
  - Best case: `O(log_2(n))`,
  - Worst case: `O(n)` (the tree is skewed tree)

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
```

## 234. Palindrome Linked List

### Approach 1: reverse the second half of the list, then compare with the first half

> - Define a fast pointer and a slow pointer
> - Make the slow pointer move till the middle,
> - reverse slow.next
> - Firsthalf pointing at the head, secondhalf pointing at reverse(slow.next)
> - Check each element on the 1/2 and 1/2 of the linkedlists , to see if they are the same.

- Time: O(1.5n)
- Space: O(1.5n) = O(n)

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        //fast and slow pointers:
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = reverse(slow.next);
        ListNode firstHalf = head;
        //check if fast and "slow -> fast" parts are the same
        while(firstHalf != null && secondHalf != null){
            if(firstHalf.val != secondHalf.val) return false;
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode newHead = null;
        while (head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
```

### Approach 2: Recursive

- Time: O(n)
- Space: O(n). Because in recursion methods, And the height of the stack is based on the number of nodes. So it use linear space.

```
Example :
1-> 2-> 3-> 4-> 2-> 1

ref points 1 initially.
Make recursive calls until you reach the last element - 1.
On returning from each recurssion, check if it is equal to ref values.
ref values are updated to on each recurssion.
So first check is ref 1 -  end 1
Second ref 2 - second last 2 ...and so on.

```

```java
class Solution {
    ListNode ref;
    public boolean isPalindrome(ListNode head) {
        ref = head;
        return check(head);
    }

    public boolean check(ListNode node){
        if(node == null) return true;
        boolean ans = check(node.next);
        boolean isEqual = (ref.val == node.val)? true : false;
        ref = ref.next;
        return ans && isEqual;
    }
}

```

## 1413. Minimum Value to Get Positive Step by Step Sum

- Time: O(n)
- Space: O(1)
  > First, we get the prefix sum each time we loop through the array
  >
  > - Track the minimum prefixSum between the curr minimum and each prefixSum
  > - And then return the difference between 1 and that minimum value, simply by `1- min`.

```java
class Solution {
    public int minStartValue(int[] nums) {
        //Return the minimum positive value of startValue such that the step by step sum is never less than 1.
        /*
        prefix sum
         Get the smallest value of all the sums starting from index 0 to nums.length - 1
         if it's negative, we get its absolute value, then plus 1
         if it's positive, we plus 1
        */
        if (nums == null) {
            throw new IllegalArgumentException("Input array is null");
        }
        int min = 0;
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i ++){
            prefixSum += nums[i];
            // Find the minimum prefix sum which is <= zero, as it will help us to find the lowest negative value.
            min = Math.min(min, prefixSum);
        }
        return 1 - min;
    }
}
```

## 2068. Check Whether Two Strings are Almost Equivalent

### Approach 1: using 2 arrays of 26 size

- time: Math.max(26, word1.length()) - O(n)
- Space: O(52) - O(n)

```java
class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] one = new int[26];
        int[] two = new int[26];
        for(int i = 0; i < word1.length(); i ++){
            one[word1.charAt(i) - 'a'] ++;
            two[word2.charAt(i) - 'a'] ++;
        }
        for(int j = 0; j < 26; j ++){
            if (Math.abs(one[j] - two[j]) > 3){
                return false;
            }
        }
        return true;
    }
}
```

### Approach 2: HashMap

- Time: O(Math.max(word1.length, max of #unique characters));
- Space: O(max of #unique characters)

```java
 public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < word1.length(); i ++){
            map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0) + 1);
            map.put(word2.charAt(i), map.getOrDefault(word2.charAt(i), 0) - 1);
        }
        for(int v: map.values()){
            if (Math.abs(v) > 3){
                return false;
            }
        }
        return true;
}
```
