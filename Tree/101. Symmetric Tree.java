/*
Solution 1: Iterative

Time Complexity: O(N)

In the worst case, the algorithm needs to traverse all nodes in the binary tree once to check for symmetry. Therefore, the time complexity is O(N), where N is the number of nodes in the tree.
Space Complexity: O(N)

The iterative solution uses a stack to store nodes during the traversal. In the worst case, the stack can hold all nodes in the left and right subtrees of the root node. Therefore, the space complexity is O(N).
Solution 2: Recursive

Time Complexity: O(N)

The recursive solution checks each node once, so the time complexity is also O(N), where N is the number of nodes in the binary tree.
Space Complexity: O(H)

The space complexity is determined by the height of the recursion tree. In the worst case, the recursion can go as deep as the height of the binary tree. For a balanced binary tree, the height is O(log N), but for a skewed tree, the height can be O(N). Therefore, the space complexity is O(H), where H can be O(log N) for balanced trees and O(N) for skewed trees.
In summary, both solutions have a time complexity of O(N). However, the iterative solution has a higher space complexity of O(N), while the recursive solution has a space complexity of O(H), which can be better for balanced trees but worse for skewed trees compared to the iterative solution.
*/
class Solution {
    //Solution 1: Iterative
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val){
                return false;
            }
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }
    //Solution 2: Recursive
    public boolean isSymmetric2(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }
    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if (left == null || right == null){
            return left == right;
        }
        if (right.val != left.val){
            return false;
        }
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}

