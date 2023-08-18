class Solution {
    // BFS
    public int numIslands(char[][] grid) {
        // Use DFS to find only vertical or horizontal connections, diagonals don't
        // count
        // Then turn the 1s into 0s whenever it's visited
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    DFS(i, j, grid);
                }
            }
        }
        return count;
    }

    public void DFS(int i, int j, char[][] grid) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        DFS(i - 1, j, grid); // down
        DFS(i + 1, j, grid); // up
        DFS(i, j + 1, grid);
        DFS(i, j - 1, grid);
    }

}

//second attempt
class Solution {
    /*
    need to traverse an entire matrix
    */
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid == null) return 0;
        int numIslands = 0;
        
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == '1'){
                    numIslands += dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }
    private int dfs(char[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return 0;
        }
        //sink the current
        grid[i][j] = '0';
        //sink the neighbours
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        //found an island
        return 1;
    }
}