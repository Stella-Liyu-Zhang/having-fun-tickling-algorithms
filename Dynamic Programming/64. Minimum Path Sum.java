class Solution {
    public int minPathSum(int[][] grid) {
        // modifying the grid, and return the sum of the min path
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];
                } else {
                    int top = i < 1 ? Integer.MAX_VALUE : grid[i - 1][j];
                    int left = j < 1 ? Integer.MAX_VALUE : grid[i][j - 1];
                    grid[i][j] += Math.min(top, left);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}