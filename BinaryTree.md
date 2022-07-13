# Binary Tree
A Binary Tree is one of the most typical tree structure. As the name suggests, a binary tree is a tree data structure in which each node has at most two children, which are referred to as the left child and the right child.

Each node of the tree will have a root value and a list of references to other nodes which are called child nodes. From graph view, a tree can also be defined as a directed acyclic graph which has N nodes and N-1 edges.

## Traverse A tree
In this chapter, we will focus on the traversal methods used in a binary tree. 
- The goal of this chapter is to:

    - Understand the difference between different tree traversal methods;
    - Be able to solve preorder, inorder and postorder traversal recursively;
    - Be able to solve preorder, inorder and postorder traversal iteratively;
    - Be able to do level traversal using BFS.

## Pre-order Traversal:
Pre-order traversal is to visit the root first. Then traverse the left subtree. Finally, traverse the right subtree.
```java
 public List<Integer> preorderTraversal(TreeNode root) {
        //Preorder (Root, Left, Right) 
        List<Integer> output = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        
        if(root == null ){
            return output;
        }
        
        stack.push(root);
        while (stack.isEmpty() == false ){
            TreeNode curr = stack.pop();
            if(curr != null){
                output.add(curr.val);
                stack.push(curr.right);
                stack.push(curr.left);
            }
            
        }
        return output;
    }
```
## In-order Trsversal:
In-order traversal is to traverse the left subtree first. Then visit the root. Finally, traverse the right subtree.

Typically, for binary search tree, we can retrieve all the data in sorted order using in-order traversal. We will mention that again in another card(Introduction to Data Structure - Binary Search Tree).
```java
 public List<Integer> inorderTraversal(TreeNode root) {
        //inorder: left, node, right
        //stack: first in last out
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();

        if (root == null){ 
            return output;
        }
        while(stack.isEmpty() == false || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            output.add(root.val);
            root = root.right;
        }
        return output;
    }
```
## Post-order Traversal
Post-order traversal is to traverse the left subtree first. Then traverse the right subtree. Finally, visit the root.

> **Note:** It is worth noting that when you delete nodes in a tree, deletion process will be in post-order. 
> 
> That is to say, when you delete a node, you will delete its left child and its right child before you delete the node itself.

If you handle this tree in postorder, you can easily handle the expression using a stack. Each time when you meet a operator, you can just pop 2 elements from the stack, calculate the result and push the result back into the stack.

### 145. Binary Tree Postorder Traversal
Algorithm: 
1) First as always, error check!
```java
if (root == null) return output;
```
2) Next, we push the root into the stack that we initalized.
3) How the algo works as follows:
 - First, we come across the left node and push it to the stack, and for the right node of same parent, if the right node exists, we push it to the stack.
 - By doing this, the left node would be below the right node in the stack of the same parent node.
 - However, whenver we pop, we put it at the "0" index of the array, meaning that the topper the position is, the further it will go in the array.
 - So since the right node is at the topper of the left node with the same parent, in the array it will be behind the left node.
  ```java
 //traverse the left subtree first. Then traverse the right subtree. Finally, visit the root.
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // push the root first, which eans that it would be the last one to be popped out
        stack.push(root);
        //traverse the tree while the stack is not empty
        //get the current node, pop it off the stack,
        //stack is first in last out
        while (stack.isEmpty() == false){
            //pop the top element off the stack
            TreeNode curr = stack.pop();
            //Every time, we put the current value at the first index of the array
            output.add(0, curr.val);
            if (curr.left != null){
                stack.add(curr.left);
            }
            if (curr.right != null){
                stack.add(curr.right);
            }
        }
        return output;
  ```

  ## Level-order Traversal
 Level-order traversal is to traverse the tree level by level.

**Breadth-First Search** is an algorithm to traverse or search in data structures like a tree or a graph. The algorithm starts with a root node and visit the node itself first. Then traverse its neighbors, traverse its second level neighbors, traverse its third level neighbors, so on and so forth.

```java
We use a BFS
 public List<List<Integer>> levelOrder(TreeNode root) {
        //at level n, there would be 2^{n-1} nodes.
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;
        
        //perform BFS, need a queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (queue.isEmpty() == false){
            List<Integer> currentLevel = new ArrayList<>();
            int currsize = queue.size();
            for(int i = 0; i < currsize; i++){
                TreeNode curr = queue.remove();
                currentLevel.add(curr.val);
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            output.add(currentLevel);
            
        }
        return output;
        
    }
```

## Solve Problems recursively
