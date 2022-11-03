## 124. Binary Tree Maximum Path Sum

- 这题是经典的 "recursion 的返回值并不是我们最后要求的值" 的题型。recursion 返回的是从下至上包括当前 root 的单条最大路径（单边 subtree）；而我们要求的 maxSum 的结果是在 recursion 的过程中不断更新的，也就是跨过当前 root 包含左子树和右子树的最大路径
-
- Recursion rule:
- 1. root must be used
- 2. at most one child can be used
- 3. maxSum does not have any relationship with recursion function, need to be calculated during every recursive call
- Psuedo code:

```java
pathsum helper function: return the maximum gain one could have including the node (and maby one of its subtrees into the path)

if( root == null) return 0;
left = recurse(leftChild);
right = recurse(rightChild);

// now find the max of all the four paths
leftPath = root.value + left;
rightPath = root.value + right;
completePath = root.value + right + left;

result = max( root.value, leftPath, rightPath, completePath );

return max(root.value, leftPath, rightPath);
```

- Time: O(N), since it's a post-order traversal
- Space: O(1), if we do not consider the stack size for function calls. Otherwise, the space complexity of postorder traversal is O(h), where 'h' is the height of tree.

```java
class Solution {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        recursiveFind(root);
        return maxSum;
    }
    public int recursiveFind (TreeNode root){
        if (root == null) return 0;
        int left = recursiveFind(root.left);
        int right = recursiveFind(root.right);

        //find the max of all the 4 paths

        //find the max between one node left and one node right
        int leftPath = root.val + left;
        int rightPath = root.val + right;
        int maxofleftright = Math.max(leftPath, rightPath);
        //find the max between all paths that include one root node
        int maxOneNodeRoot = Math.max(root.val, maxofleftright);

        //the max between all possible four paths:
        int completePath = root.val + left + right;
        int maxAll = Math.max(completePath, maxOneNodeRoot);

        maxSum = Math.max(maxSum, maxAll);
        return maxOneNodeRoot;
    }
}
```

> Complexity of Postorder traversal
> The time complexity of postorder traversal is O(n), where 'n' is the size of binary tree.

> Whereas, the space complexity of postorder traversal is O(1), if we do not consider the stack size for function calls. Otherwise, the space complexity of postorder traversal is O(h), where 'h' is the height of tree.

## 132. Palindrome Partitioning II

```
1) cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
2) If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].

The 2nd point reminds us of using dp (caching).

a   b   a   |   c  c
                j  i
       j-1  |  [j, i] is palindrome
   cut(j-1) +  1
```
