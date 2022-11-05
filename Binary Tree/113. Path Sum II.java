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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        recur(list, root, targetSum, new ArrayList<>());
        return list;
    }
    public void recur (List<List<Integer>> list, TreeNode root, int targetSum, List<Integer> temp){
        if (root == null){
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum){
            list.add(new ArrayList(temp));
        }else{
            recur(list, root.left, targetSum - root.val, temp);
            recur(list, root.right, targetSum - root.val, temp);
        }
        temp.remove(temp.size() - 1);
    }
}