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
 Time Complexity:
The time complexity of this solution is O(N), where N is the number of nodes in the larger of the two trees. In the worst case, the function needs to compare all nodes of both trees. If one of the trees has more nodes than the other, we only need to traverse the larger tree to determine they are different.

Space Complexity:
The space complexity of the solution is O(H), where H is the height of the recursion tree. In the worst case, the recursion can go as deep as the height of the larger tree. In a balanced binary tree, the height is O(log N), but in the worst case (skewed tree), the height can be O(N) for a tree with N nodes.

To sum up, the time complexity is O(N), and the space complexity is O(H), where H can be O(log N) for balanced trees and O(N) for skewed trees.
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;
        if (p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}