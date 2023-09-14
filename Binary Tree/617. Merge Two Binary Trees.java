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
    1. overlap -> sum values up as the new value
    Time: O(N)
    Space: O(N), where in the worst case
    O(log(N))

    */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        TreeNode temp = new TreeNode(root1.val + root2.val);
        temp.left = mergeTrees(root1.left,root2.left);
        temp.right = mergeTrees(root1.right, root2.right);
        return temp;
    }
}