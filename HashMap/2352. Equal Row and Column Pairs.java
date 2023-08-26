//Brute force solution
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                //grid[i][j]
                boolean match = true;
                for(int k = 0; k < n; k++){
                    if(grid[i][k] != grid[k][j]){
                        match = false;
                        break;
                    }
                }
                count += match ? 1: 0;;
            }
        }
        return count;
    }
}
//HashMap solution
class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map = new HashMap();
        for(int[] row: grid){
            String rowString = Arrays.toString(row);
            map.put(rowString, map.getOrDefault(rowString, 0) + 1);
        }
        int count = 0;
        for(int c = 0; c < grid.length; c ++){
            int[] colArray = new int[grid.length];
            for(int r = 0; r < grid.length; r ++){
                colArray[r] = grid[r][c];
            }
            count += map.getOrDefault(Arrays.toString(colArray), 0);

        }


        return count;
    }
}