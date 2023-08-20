class Solution {
    /*
    Time: O(mn)
    Space: O(1)
    */
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;

        int res = 0;
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < col; j ++){
                if(grid[i][j] == 1){
                    res += 4;
                    if(i > 0 && grid[i-1][j] == 1){
                        res -= 2;
                    }
                    if(j > 0 && grid[i][j - 1] == 1){
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }
}