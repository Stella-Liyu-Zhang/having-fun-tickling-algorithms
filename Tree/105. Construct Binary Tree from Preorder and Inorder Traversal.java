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
    Preorder traversal follows `Root -> Left -> Right
    In-order traversal follows `Left -> Root -> Right

    Binary tree:
    root, left subtree, and right subtree

    pre-order, the first one would be root
    goes into inorder array, everything before 8 is the left, and everything after 8 is the right subtree

    preOrder: [3, 9, 20, 15, 7]
    Inorder: [9,3,15,20,7]
    9 0
    3 1
    15 2
    20 3
    7 4

    doesn't have to iterate through the array, could extract the value in O(1).
 */
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int preorderIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIdx = 0;
        for(int i = 0; i < inorder.length; i ++){
            map.put(inorder[i] , i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right){
        if (left > right) return null;

        int rootVal = preorder[preorderIdx];
        preorderIdx ++;
        TreeNode root = new TreeNode(rootVal);

        root.left = arrayToTree(preorder, left, map.get(rootVal) - 1);
        root.right = arrayToTree(preorder, map.get(rootVal) + 1, right);
        return root;
    }
}