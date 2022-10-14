/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // traverse the tree recursively
        // O(n), make sure to traverse all the nodes
        // space complexity also O(n)
        return isValid(root, null, null);

    }

    public boolean isValid(TreeNode root, Integer max, Integer min) {
        if (root == null) { // since an empty tree is a vld bst
            return true;
        } else if (max != null && root.val >= max || min != null && root.val <= min) {
            return false;
        } else {
            return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
        }
    }
}