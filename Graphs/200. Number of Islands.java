class Solution {
    public int numIslands(char[][] grid) {
        // DFS
        // Find connected components in graph
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // if we see a "1", find the whole island structure of the 1.
                if (grid[i][j] == '1') {
                    count += 1; // we found an island, so we increment count by 1;
                    callDFS(grid, i, j);
                }
            }
        }
        return count;
    }

    public void callDFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        callDFS(grid, i + 1, j);
        callDFS(grid, i - 1, j);
        callDFS(grid, i, j + 1);
        callDFS(grid, i, j - 1);
    }
}