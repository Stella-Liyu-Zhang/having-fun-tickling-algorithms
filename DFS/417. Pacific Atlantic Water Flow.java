class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        //DFS is a recursive approach
        // O(MN), Space O(MN)

        if (heights == null || heights.length == 0){
            return ans;
        }

        int m = heights.length;
        int n = heights[0].length;

        //store to see if it could be flown into which ocean
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i = 0; i < m; i ++){
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, n-1);
        }
        for(int j = 0; j < n; j ++){
            dfs(heights, pacific, Integer.MIN_VALUE, 0, j);
            dfs(heights, atlantic, Integer.MIN_VALUE, m-1, j);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, boolean[][] visited, int pre, int i, int j){
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length){
            return;
        }
        if (visited[i][j] == true){
            return;
        }
        if (heights[i][j] < pre){
            return;
        }
        visited[i][j] = true;
        dfs(heights, visited, heights[i][j], i + 1, j);
        dfs(heights, visited, heights[i][j], i - 1, j);
        dfs(heights, visited, heights[i][j], i, j - 1);
        dfs(heights, visited, heights[i][j], i, j + 1);
    }
}