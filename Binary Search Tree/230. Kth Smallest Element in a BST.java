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
    public int kthSmallest(TreeNode root, int k) {
        // The idea is to build an inorder traversal of BST which is an array sorted in
        // the ascending order. Now the answer is the k - 1th element of this array.
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(ans, root);
        return ans.get(k - 1);
    }

    // inorder traversal is left, root, right, which would be sorting the nodes in
    // an ascending order
    public void inOrder(List<Integer> ans, TreeNode root) {
        if (root != null) {
            inOrder(ans, root.left);
            ans.add(root.val);
            inOrder(ans, root.right);
        }
    }
}