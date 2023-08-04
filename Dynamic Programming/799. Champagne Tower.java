class Solution {
    /*
    pascal's triangle
    
                      n
              (n-1)/2   (n-1)/2
    ((n-1)/2-1)/2   (n-1)/2-1      ((n-1)/2-1)/2

    T/S: O(r²)/O(r^2), where r = queryRow
    Since max(r) = 100, so technically both are O(1)

    101: 99 +2, where 2 comes from that i+1, and we loop through 100 times.
    */
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0){
            return 0;
        }
        double[][] dp = new double[101][101];
        dp[0][0] = (double) poured;
        for(int i = 0; i <= query_row; i ++){
            for(int j = 0; j <= i; j++){
                double q = (dp[i][j] - 1.0)/2.0;
                if (q>0){
                    dp[i+1][j] += q;
                    dp[i+1][j+1] += q;
                }
            }
            
        }
        return Math.min(1, dp[query_row][query_glass]);
    }
}