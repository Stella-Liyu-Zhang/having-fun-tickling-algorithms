class Solution {
    /*


    */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n  = matrix[0].length;
        int row = m-1;
        int col = 0;
        while(row >= 0 && col < n){
            if(matrix[row][col] > target){
                row --;
            }else if (matrix[row][col] < target){
                col ++;
            }else{
                return true;
            }
        }
        return false;
    }
}