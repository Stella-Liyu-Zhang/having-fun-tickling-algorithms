class NumMatrix {
    /*
     * sub-problem: dp[i][j] represents preSum of all elements in the rectangle area between (0,0) to (i-1, j-1)
     * base case: dp[1][1] = matrix[0][0]
     * recurrence relation: dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
     * explanation: top rectangle sum + left rectangle sum - top left common rectangle + new value at current point
    Time Complexity:

    NumMatrix: O(n*m) to create the sums matrix.
    sumRegion: O(1)

    Space Complexity: O(n*m)
    */
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 1; i <= matrix.length; i ++){
            for(int j = 1; j <= matrix[0].length; j ++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */