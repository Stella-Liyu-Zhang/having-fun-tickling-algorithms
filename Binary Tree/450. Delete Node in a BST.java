/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*

    Cases:
    1. the node is a leaf, we just remove it
    2. The node has one child, we remove it
        1.  
    3. 
    */
    //go right once, then all way left.
    public int successor(TreeNode root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }

    public int predecessor(TreeNode root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        
        if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else if (key < root.val){
            root.left = deleteNode(root.left, key);
        }else{//delete root itself
            //the root is a leaf
            if(root.left == null && root.right == null){
                root = null;
            //delete the current node, and then continue to iterate on its left
            }else if (root.left != null){
                //find the predecessor
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }else if (root.right != null){
                root.val = successor (root);
                root.right = deleteNode(root.right, root.val);
            }   
        }
        return root;
    } 
}