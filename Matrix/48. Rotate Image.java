class Solution {
    public void rotate(int[][] matrix) {
        //first, transpose the matrix
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < i; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        //second, swipe the positions horizontally (swap(matrix[i][j], matrix[i][matrix.length-1-j])
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix.length/2; j++){
                int temp = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}