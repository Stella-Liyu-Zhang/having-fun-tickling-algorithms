class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

        if (root == null)
            return ans;
        String currpath = Integer.toString(root.val);

        if (root.left == null && root.right == null) {
            ans.add(currpath);
        }
        if (root.left != null) {
            dfs(root.left, currpath, ans);
        }
        if (root.right != null) {
            dfs(root.right, currpath, ans);
        }
        return ans;
    }

    public void dfs(TreeNode root, String currpath, List<String> list) {
        currpath += "->" + root.val;
        if (root.left == null && root.right == null) {
            list.add(currpath);
            return;
        }
        if (root.left != null) {
            dfs(root.left, currpath, list);
        }
        if (root.right != null) {
            dfs(root.right, currpath, list);
        }
    }
}