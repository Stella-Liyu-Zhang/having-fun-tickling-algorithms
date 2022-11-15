class Solution {
    /*
     * minpath[k][i] = Math.min(minpath[k+1][i], minpath[k+1][i+1]) +
     * triangle[k][i];
     * 
     * Or even better, since the row minpath[k+1] would be useless after minpath[k]
     * is computed, we can simply set minpath as a 1D array, and iteratively update
     * itself:
     * For the kth level:
     * minpath[i] = min( minpath[i], minpath[i+1]) + triangle[k][i];
     * 
     * From a quick glance it preempts needing a bounds check on A[j+1]
     * 
     * To handle the last list which is the starting point..
     * e.g. - if the last list in the triangle is 4,1,8,3 then the bottom list/row
     * should be 0,0,0,0
     * Hope this makes sense
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] minpath = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                minpath[j] = Math.min(minpath[j], minpath[j + 1]) + triangle.get(i).get(j);
            }
        }
        return minpath[0];
    }
}