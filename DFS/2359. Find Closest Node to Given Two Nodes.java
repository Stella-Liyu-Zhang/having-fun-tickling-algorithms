class Solution {
    public void dfs(int node, int[] edges, boolean[] visited, int[] distance){
        //mark as it visited 
        visited[node] = true;
        //check the outgoing edge
        int neighbor = edges[node];
        //-1 means there is no outgoing edge, so we skip it
        if (neighbor != -1 && !visited[neighbor]){
            //the dist going to node v form node u is simply d[u] +1            
            distance[neighbor] = distance[node] +1;
            //continue to dfs on neighbor
            dfs(neighbor, edges, visited, distance);
        }
    }
    

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        //Since there is only at most 1 outgoing edge, we can simply use DFS.
        int ans = -1;
        int n = edges.length;

        // d1[i]: shortest dist to node i starting from node 1
        // d2[i]: shortest dist to nodes i starting from node 2
        int[] d1 = new int[n];
        int[] d2 = new int[n];

        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];

        dfs(node1, edges, visited1, d1);
        dfs(node2, edges, visited2, d2);

        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++){
            if (visited1[i] && visited2[i] && Math.max(d1[i], d2[i]) < minDist){
                minDist = Math.max(d1[i], d2[i]);
                ans = i;
            }
        }

        return ans;
    }
}