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
