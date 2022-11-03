class Solution {
    /*
     * f(n) = f(0) * f(n - 1) + f(1) * f(n - 2) + ...+ f(n - 1) * f(0),
     * while the n in f(n) means the number of BST trees with n nodes.
     * Time : O(n ^ 2)
     * Space: O(n)
     */
    public int numTrees(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        int[] catalan = new int[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        return catalan[n];
    }
}