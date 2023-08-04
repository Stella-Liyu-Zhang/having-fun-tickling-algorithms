class Solution {
    /*
    Time complexity : O(Nlog⁡N) because of sorting of input data.
    Space complexity : O(log⁡N)
    In Java, Arrays.sort() is implemented using a variant of the Quick Sort algorithm which has a space complexity of O(logn)
    */
    public int twoCitySchedCost(int[][] costs) {
        int len = costs.length/2;
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] takeA, int[] takeB){
                return takeA[0] - takeA[1] - (takeB[0] - takeB[1]);
            }
        });

        int totalCost = 0;
        for(int i = 0; i < len; i ++){
            totalCost += costs[i][0] + costs[i+len][1];
        }
        return totalCost;
        
    }
}