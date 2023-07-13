class Solution {
    public int diameter = -1;

    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return diameter;
    }

    private int findHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = 1 + findHeight(root.left);
        int right = 1 + findHeight(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right);
    }
}