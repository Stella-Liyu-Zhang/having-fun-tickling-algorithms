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
    level 0: root
    level 1: root.left, root. right
    Queue

    */
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int ans = 0;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(queue.isEmpty() == false){
            level ++;
            int sum = 0;
            for (int sz = queue.size(); sz > 0; --sz) {
                TreeNode node = queue.poll();
                sum += node.val;

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            if(maxSum < sum){
                maxSum = sum;
                ans = level;
            }
        }
        return ans;

    }
}