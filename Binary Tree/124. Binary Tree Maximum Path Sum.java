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

/**
 * pathsum helper function: return the maximum gain one could have including the
 * node (and maby one of its subtrees into the path)
 * 
 * if( root == null) return 0;
 * left = recurse(leftChild);
 * right = recurse(rightChild);
 * 
 * // now find the max of all the four paths
 * leftPath = root.value + left;
 * rightPath = root.value + right;
 * completePath = root.value + right + left;
 * 
 * result = max( root.value, leftPath, rightPath, completePath );
 * 
 * return max(root.value, leftPath, rightPath);
 * 
 * 
 */
class Solution {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        recursiveFind(root);
        return maxSum;
    }

    public int recursiveFind(TreeNode root) {
        if (root == null)
            return 0;
        int left = recursiveFind(root.left);
        int right = recursiveFind(root.right);

        // find the max of all the 4 paths

        // find the max between one node left and one node right
        int leftPath = root.val + left;
        int rightPath = root.val + right;
        int maxofleftright = Math.max(leftPath, rightPath);
        // find the max between all paths that include one root node
        int maxOneNodeRoot = Math.max(root.val, maxofleftright);

        // the max between all possible four paths:
        int completePath = root.val + left + right;
        int maxAll = Math.max(completePath, maxOneNodeRoot);

        maxSum = Math.max(maxSum, maxAll);
        return maxOneNodeRoot;
    }
}

//another way to solve the problem:
class Solution {
    /*
    bottom up approach
    left, right and current
    postorder traversal: left, right, currnode
    nodes were put from bottom to top.
    max = -infinity

    bound our sum to 0 to ensure we get the max!
    each time we get the maximum of the current maximum and 0
    10 + max(-5,0) = 10!!

    max between left and right

    Time: O(n)
    postorder, touch all the nodes for one single time
    Space: O(H)
    */
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        //Set it to minvalue just in case that all the nodes are negative
        postOrder(root);
        return max;
    }

    private int postOrder(TreeNode root){
        if (root == null){
            return 0;
        }
        //bound to 0.
        int left = Math.max(0, postOrder(root.left));
        int right = Math.max(0, postOrder(root.right));
        
        int curr = left+right+root.val;
        max = Math.max(curr,max);
        return Math.max(left,right) + root.val;
    }
}