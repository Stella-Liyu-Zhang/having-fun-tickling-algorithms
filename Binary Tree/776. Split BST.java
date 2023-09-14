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
   either subtree rooted at root.left or subtree rooted at root.right should be split.

    if (root.val <= target) split subtree at root.right
    root.val > target, split subtree at root.left

    ans[0] <= target
    ans[1] >= target

    Time Complexity: O(N) where N is the number of nodes in the input tree, as each node is checked once.
    Space Complexity: O(N)
    */
    public TreeNode[] splitBST(TreeNode root, int target) {
        TreeNode[] ans = new TreeNode[2];
        if(root == null){
            return ans;
        }
        if(root.val <= target){
            ans = splitBST(root.right, target);
            root.right = ans[0];
            ans[0] = root;
        }else{
            ans = splitBST(root.left, target);
            root.left = ans[1];
            ans[1] = root;
        }
        return ans;
    }
}