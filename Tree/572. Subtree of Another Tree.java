class Solution {
    /*
    isIdentical(s,t)= 
    s.val==t.val 
    AND 
    isIdentical(s.left,t.left) 
    AND 
    isIdentical(s.right,t.right)
    */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(subRoot == null) return true;
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if (s == null || t == null) return false;
        return (s.val == t.val) && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
