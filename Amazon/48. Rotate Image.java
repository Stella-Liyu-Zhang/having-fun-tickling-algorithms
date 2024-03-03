class Solution {
    /*
    transpose, then reverse
    [0,2]
    [2,4]
    [4,2]
    [2,0]
    [i,j]
    [i,n-1-j]
    */
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
    public void transpose(int[][] matrix){
        for(int i = 0; i < matrix.length; i ++){
            for(int j = i+1; j < matrix.length; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public void reverse(int[][] matrix){
        int n =  matrix.length;
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix.length/2; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}