class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, root);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        if (head.val == root.val && matches(head, root) == true) {
            return true;
        }
        return dfs(head, root.left) || dfs(head, root.right);
    }

    // go down in a binary tree, to see if all the nodes matches the linkedlist
    // if head == null, means we found all the nodes, return true
    private boolean matches(ListNode head, TreeNode root) {
        if (head == null) { // we found all the nodes inn the linkedlist
            return true;
        }
        if (root == null || head.val != root.val) {
            return false;
        }
        return matches(head.next, root.right) || matches(head.next, root.left);
    }
}