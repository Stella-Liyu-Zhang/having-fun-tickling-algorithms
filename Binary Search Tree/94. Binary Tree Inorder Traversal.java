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
// O(n), will go through all the nodes at least.
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // inorder: left, node, right
        // stack: first in last out
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    public void helper(TreeNode root, List<Integer> ans) {
        if (root != null) {
            helper(root.left, ans);
            ans.add(root.val);
            helper(root.right, ans);
        }
    }

}