class Solution {
    /*
    Time: O(n^2)
    Space: O(n)
    */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numOfComponents = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i ++){
            if(!visited[i]){
                numOfComponents ++;
                dfs(i, isConnected, visited);
            }
        }
        return numOfComponents;
    }
    private void dfs(int node, int[][] isConnected, boolean[] visit){
        visit[node] = true;
        for(int i = 0; i < isConnected[0].length; i ++){
            if (!visit[i] && isConnected[node][i] == 1 ){
                dfs(i, isConnected, visit);
            }
        }
    }
}