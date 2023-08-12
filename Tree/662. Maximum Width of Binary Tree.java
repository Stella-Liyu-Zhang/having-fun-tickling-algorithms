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
 /*
    binary tree can be represented by an array (assume the root begins from the position with index 1 in the array). 
    If the index of a node is i, 
    the indices of its two children are 2*i and 2*i + 1

 */
class Solution {
    private int max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        List<Integer> list = new LinkedList<>();
        dfs(root, 0, 1, list);
        return max;
    }
    //here the index represents the index of the root
    private void dfs(TreeNode root, int level, int index, List<Integer> list){
        if (root == null) return;
        if (level == list.size()){
            list.add(index);
        }
        max = Math.max(max, index + 1 - list.get(level));
        dfs(root.left, level + 1, index*2, list);
        dfs(root.right, level + 1, index*2 + 1, list);
    }
}