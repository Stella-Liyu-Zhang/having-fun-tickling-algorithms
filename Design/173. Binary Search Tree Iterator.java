class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        //partial Inorder traversal;
        partialInorder(root);
    }
    private void partialInorder(TreeNode node){
        while (node != null){
            stack.push(node);
            node = node.left;
        }
    }
    public int next() {
        TreeNode top = stack.pop();
        partialInorder(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}