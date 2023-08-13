class Solution {
    /*
    root will be the 
    Regardless whether these nodes exist:

    the position of left child is always parent_pos * 2;
    the position of right child is always parent_pos * 2 + 1;
    the position of parent is always child_pos / 2;

            8
    4

    griid[4][8]
            0
        0       1
     0   1     2   3
   0 1  2 3   4 5  6 7
    */

    public int pathSum(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[][] arr = new int[5][8];

        for(int n: nums){
            int depth = n/100; //level, 1 based index
            int index = (n%100)/10 - 1; //position, 0 based index
            int value = n%10;
            arr[depth][index] = arr[depth-1][index/2] + value; //the parent's value

        }

        int sum = 0;
        for(int i = 1; i < 5; i ++){
            for(int j = 0; j < 8; j++){
                //if we are at the lowest level (4th) or the curr value is not 0, but both the left and right child are valued at 0, we add to sum
                if(i == 4 || arr[i][j] != 0 && arr[i+1][j*2] == 0 && arr[i + 1][j*2+1] == 0){
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }
}