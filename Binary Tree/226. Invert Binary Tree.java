class Solution {
    // Iterative solution
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        // Iterative solution using a Queue
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            /// swap node.left and node.right
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
    // Recursive solution
    /*
     * public TreeNode invertTree(TreeNode root) {
     * if (root == null){
     * return root;
     * }
     * //Recursive Mode
     * TreeNode left = invertTree(root.left);
     * TreeNode right = invertTree(root.right);
     * 
     * root.left = right;
     * root.right = left;
     * 
     * return root;
     * }
     */
}