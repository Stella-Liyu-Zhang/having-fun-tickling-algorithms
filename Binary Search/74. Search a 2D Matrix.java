class Solution {
    /*
    m*n
    O(mn)
    O(log(mn))
    matrix-> flattened 1d array
    [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
    60 -> 11
    4 -> no of cols
    row: 2 -> 11/4
    col : 3 -> 11 % 4
    map each element of the 1d array into the matrix
    1) matrix  is empty -> return false
    2) if matrix only contains 1 element == target -> return true
    
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 && matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n - 1;
        while(left <= right){
            int middle = left + (right - left)/2; //avoid overflow
            int row = middle / n;
            int col = middle % n;
            if(matrix[row][col] == target){
                return true;
            }else if (matrix[row][col] < target){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return false;
    }
}