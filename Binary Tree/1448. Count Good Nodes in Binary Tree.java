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
    1. need to touch all the nodes in the tree, 
    2. track the biggest value in the path so far, and compare with the biggest one



    */
    int numGoodNodes = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }
    private void dfs (TreeNode node, int maxSoFar){

        if(maxSoFar <= node.val){
            numGoodNodes ++;
            maxSoFar = node.val;
        }
        if(node.right != null){
            dfs(node.right, maxSoFar);
        }
        if(node.left != null){
            dfs(node.left, maxSoFar);
        }
    }
}