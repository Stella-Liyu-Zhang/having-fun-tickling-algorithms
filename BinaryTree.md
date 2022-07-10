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

## In-order Trsversal:
In-order traversal is to traverse the left subtree first. Then visit the root. Finally, traverse the right subtree.

Typically, for binary search tree, we can retrieve all the data in sorted order using in-order traversal. We will mention that again in another card(Introduction to Data Structure - Binary Search Tree).

## Post-order Traversal
Post-order traversal is to traverse the left subtree first. Then traverse the right subtree. Finally, visit the root.

> **Note:**I t is worth noting that when you delete nodes in a tree, deletion process will be in post-order. That is to say, when you delete a node, you will delete its left child and its right child before you delete the node itself.

If you handle this tree in postorder, you can easily handle the expression using a stack. Each time when you meet a operator, you can just pop 2 elements from the stack, calculate the result and push the result back into the stack.


