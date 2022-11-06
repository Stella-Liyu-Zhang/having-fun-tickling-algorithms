# Binary Search Tree

A Binary Search Tree is a special form of a binary tree. The value in each node must be greater than (or equal to) any values in its left subtree but less than (or equal to) any values in its right subtree.

## Definition of a BST

A binary search tree (BST), a special form of a binary tree, satisfies the binary search property:

1. The value in each node must be greater than (or equal to) any values stored in its left subtree.
2. The value in each node must be less than (or equal to) any values stored in its right subtree.

Like a normal binary tree, we can traverse a BST in preorder, inorder, postorder or level-order. However, it is noteworthy that inorder traversal in BST will be in ascending order. Therefore, the inorder traversal is the most frequent used traversal method of a BST.

## Learn one iterative inorder traversal, apply it to multiple tree questions (Java Solution)

## LinkedList in Binary Tree (BFS + DFS + Preorder Traversal)

- Time complexity: `O(N*min(L,H))`
- Space complexity: `O(H)`

### Approach 1: DFS + BFS

- input: a tree and a linkedlist
- preorder traversal: visit the node, go left, then go right.

  > - dfs recursive function
  >
  >   - pass in the head and root
  >   - if root is null, return false
  >   - if head's value is equal to root.val and bfs result is true, return true
  >   - otherwise, we traverse root.left and root.right with the dfs method.
  >
  > - bfs
  >   - Define a queue and add the root
  >   - Move our listNode forward, since we already found the head
  >   - check if the current value is the curr list node.

      - return if curr is null;

```java
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, root);
    }

    public boolean dfs(ListNode head, TreeNode root){
        if (root == null){
            return false;
        }
        if (head.val == root.val && bfs(head,root)){
            return true;
        }
        return dfs(head, root.left) || dfs(head,root.right);
    }

    public boolean bfs(ListNode head, TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ListNode curr = head.next;
        while (queue.isEmpty() == false && curr != null){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                if (node.left != null && node.left.val == curr.val){
                    queue.add(node.left);
                }
                if (node.right != null && node.right.val == curr.val){
                    queue.add(node.right);
                }
            }
            if (!queue.isEmpty()){
                curr = curr.next;
            }
        }
        return curr == null;
    }
}
```

### Approach 2: DFS + DFS

go down in a binary tree, to see if all the nodes matches the linkedlist
if head == null, means we found all the nodes, return true

```java
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head,root);
    }

    private boolean dfs(ListNode head, TreeNode root){
        if (root == null){
            return false;
        }
        if (head.val == root.val && matches(head, root) == true){
            return true;
        }
        return dfs(head, root.left) || dfs(head, root.right);
    }
    //go down in a binary tree, to see if all the nodes matches the linkedlist
    //if head == null, means we found all the nodes, return true
    private boolean matches(ListNode head, TreeNode root){
        if (head == null) { //we found all the nodes inn the linkedlist
            return true;
        }
        if (root == null || head.val != root.val){
            return false;
        }
        return matches(head.next, root.right) || matches(head.next,root.left);
    }
}

```

## 199. Binary Tree Right Side View

### Approach 1: BFS

> Queue, store treenodes [ 4 , 5 , 6 ]
> res = [ 1, 3 , 6 ]
> size = 3， how many times we need to pull from the queue in order to perform our level order traversal
> i = 0, iterate from 0 to size-1, a loop telling us that we need to pull from our queue that many times
> i == size - 1, this is how we know we have the rightmost node from that level

- time: O(N), n is number of nodes in our tree
- Space: O(N), since our queue will grow to the size of our largest level containing N nodes

```java
 public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty() == false){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                if (i == size-1){
                    result.add(node.val);
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return result;
}

```

### Approach 2: DFS

- using a recursive method
- if root is null, return
- if the current depth equals to the size of the list

```java
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        getRightRecur(root, ans, 0);
        return ans;
    }
    private void getRightRecur(TreeNode root, List<Integer> ans, int currDepth){
        if (root == null){
            return;
        }
        if (currDepth == ans.size()){
            ans.add(root.val);
        }
        getRightRecur(root.right, ans, currDepth + 1);
        getRightRecur(root.left, ans, currDepth + 1);
    }
```

## 404. Sum of Left Leaves

### Approach 1: Recursive

- Time: O(n)
- Space: O(n)

```java
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if(root.left != null ){ //check if it's a leaf.
            if (isLeaf(root.left)){
                sum += root.left.val;
            }else{ //not a leaf, iterate on the left child.
                sum += sumOfLeftLeaves(root.left);
            }
        }
        //iterate on the right child to proceed to above process
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
    private boolean isLeaf(TreeNode node){
        if (node.left == null && node.right == null){
            return true;
        }
        return false;
    }
```

### Approach 2: iterative solution

- Time: O(n)
- Space: O(n)

```java
 public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //add to the queue if it's not the left child
            TreeNode node = queue.poll();
            if (node.left != null){//check if it's a leafnode.
                if (isLeaf(node.left)){
                    sum += node.left.val;
                }else{
                    queue.add(node.left);
                }
            }
            if (node.right != null) queue.add(node.right);
        }
        return sum;
    }
    private boolean isLeaf(TreeNode node){
        return (node.left == null && node.right == null);
    }
```
