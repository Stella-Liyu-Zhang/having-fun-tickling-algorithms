class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //add to the queue if it's not the left child
            TreeNode node = queue.poll();
            if (node.left != null){//check if it's a leafnode.
                if (isLeaf(node.left)){
                    sum += node.left.val;
                }else{
                    queue.add(node.left);
                }
            }
            if (node.right != null) queue.add(node.right);
        }
        return sum;
    }
    private boolean isLeaf(TreeNode node){
        return (node.left == null && node.right == null);
    }
}
