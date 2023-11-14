class Solution {
    /*
    in-place: an algorithm that operates directly on the input data structure without requiring extra space proportional to the input size. 

    matrix[i][j] == 0,
    matrix[i][x] == 0
    matrix[x][j] == 0

    Brutal force solution 
    Time: O(N*M), where M and N are number of rows and cols
    Space: O(M+N)

    Optimized solution: 
    Mark the first row and first col, if they have 0s, we make a mark.

    */
    public void setZeroes(int[][] matrix) {
        Boolean firstCol = false;
        Boolean firstRow = false;

        int r = matrix.length;
        int c = matrix[0].length;

        //check the first row
        for(int i = 0; i < r; i ++){
            if(matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }
        //check the first col
        for(int i = 0; i < c; i ++){
            if(matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }
        //Check the inner matrix, and mark the first col and first row. 
        for(int i = 1; i < r; i ++){
            for(int j = 1; j < c; j ++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < r; i ++){
            for(int j = 1; j < c; j ++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstCol){
            for(int i = 0; i < r; i ++){
                matrix[i][0] = 0;
            }
        }
        if(firstRow){
            for(int j = 0; j < c; j ++){
                matrix[0][j] = 0;
            }
        }
    }
}