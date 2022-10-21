## 21. Merge Two Sorted Lists

> O(n1+n2) recursive stack space, where n1-length of LL1 and n2-length of LL2
> Obviously, for both recursive and iterative, it's O(N+M) where N and M are lengths of the 2 linked lists

```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            //recursively
            //make the next node of the smaller one to be the result after calling the recursive method
            if (list1 == null) return list2;
            if (list2 == null) return list1;
                if (list1.val <= list2.val){
                    list1.next = mergeTwoLists (list1.next, list2);
                    return list1;
                }else{
                    list2.next = mergeTwoLists (list1, list2.next);
                    return list2;
                }
    }
}

 //iteratively
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            while(list1 != null && list2 != null){
                if(list1.val <= list2.val){
                    curr.next = list1;
                    list1 = list1.next;
                }else{
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
            }

            curr.next = list1 == null ? list2 : list1;
            return dummy.next;
```

### Followup:

23. Merge k Sorted Lists

## 20. Valid Parentheses

when we are processing the right parenthesis, if the stack is empty, which means there is nothing to pop, smth doesn't really match, then return false;
Or if the top one on the stack is not the corressponding left parenthese, we also return false

- Ultimately, we need to return whether or not the stack is empty. If it's not, it means that there are some lefted ones withou any pairs. So we return `return stack.isEmpty();`
- Time complexity: s.length() - O(n)
- Space complexity: s.length() / 2 roughly, since we only allocated the stack to hold half of the data
  - O(n)

```java
class Solution {
    public boolean isValid(String s) {
        //({[])}]
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()){
            if ( c == '{') stack.push('}');
            else if (c == '[') stack.push (']');
            else if (c == '(') stack.push(')');
            else{//c is the right part
              if(stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
```

## 1. Two Sum

Using a hashmap

- @key: target - nums[i]
- @value: i
  - Then loop through the hashmap, to see if the map contains its difference with target. if so, we return the ans.
- Time complexity: O(n)
- Spcae complexity: O(n);

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
       //make a hashmap with key as the integer, value as its difference with the target. and we loop through the hashmap, to check if the corressponding value is within the nums array.
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(target-nums[i])){
                ans[1] = i;
                ans[0] = map.get(target-nums[i]);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
```

## 9. Palindrome Number

```java
class Solution {
    //Time complexity: x.length() /2
    // Space: constant
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int left = 0, right = s.length() - 1;
        while (left <= right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }
}
```

## 242. Valid Anagram

```
Time complexity: max (26, s.length(), t.length)
Space complexity: 26*2 = 52
```

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] astore = new int[26];
        int[] bstore = new int[26];
        for(char c: s.toCharArray()){
            astore[c - 'a'] ++;
        }
        for(char c: t.toCharArray()){
            bstore[c - 'a']++;
        }
        for(int i = 0; i < 26; i ++){
            if (astore[i] != bstore[i]){
                return false;
            }
        }
        return true;
    }
}
```

## 387. First Unique Character in a String

- Time complexity: s.length()
- Space complexity: number of unique characters in the string.

Note that to get the index of the first unique string, we need to loop through s, not the hashmap.

```java
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        for(int i = 0; i < s.length(); i ++){
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
```

## 160. Intersection of Two Linked Lists

Approach 1: Intersection: keep track of what we already have seen
keep track one of the list, then go to the other list to see if we have seen it before

Throw one list into a hashset, record it is b1, b2, in our hashset

Time: O(m+n)
Space: visited allocated, O(min(m,n))
O(n) in general

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> visited = new HashSet<>();
        while(headA != null){
            visited.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if (visited.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
```

## Approach 2:

1. Traverse the shorter one and longer one at the same time, set to the header of the other one pointer to the head,
   > "hey nodeB I will chase you till the day I meet you"

Time: O(m+n)
Space: constant

```java
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB){
            if(pointerA == null){
                pointerA = headA;
            }else{
                pointerA = pointerA.next;
            }
            if(pointerB == null){
                pointerB = headB;
            }else{
                pointerB = pointerB.next;
            }
        }

        return pointerA;
    }
```

## Approach 3:

Calcualte length, wait for the shorter to catch up, and get the intersection

## 257. Binary Tree Paths

DFS, recursions

one gets added to the string, left node gets passed in if it's not null, right same logic.
Time: O(n)
Space: O(n)

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

        if(root == null) return ans;
        String currpath = Integer.toString(root.val);

        if(root.left == null && root.right == null){
            ans.add(currpath);
        }
        if(root.left != null){
            dfs(root.left, currpath, ans);
        }
        if(root.right != null){
            dfs(root.right, currpath, ans);
        }
        return ans;
    }

    public void dfs(TreeNode root, String currpath, List<String> list){
        currpath += "->" +root.val;
        if (root.left == null && root.right == null){
            list.add(currpath);
            return;
        }
        if(root.left != null){
            dfs(root.left, currpath, list);
        }
        if(root.right != null){
            dfs(root.right, currpath, list);
        }
    }
}
```

## 206. Reverse Linked List

Approach 1: Stack, O(n)

```java
 public ListNode reverseList(ListNode head) {
        //prev, node, node.next
        //traverse the linkedlist, put into the stack

        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode dumm = new ListNode(-1);
        head = dumm;
        while (stack.isEmpty() == false){
            ListNode curr = stack.pop();
            head.next = new ListNode(curr.val);
            head = head.next;
        }
        return dumm.next;
    }
```

Approach 2: constant time operation

```java

```

## 160. Intersection of Two Linked Lists

```java

```
