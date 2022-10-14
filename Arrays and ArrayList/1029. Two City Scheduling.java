class Solution {
    public int twoCitySchedCost(int[][] costs) {
        /*
         * A1, A2, A3, A4
         * min half numbers of (B1-A1, B2-A2, B3-A3, B4-A4), added up to the totalA
         * 
         */
        // Assuming that we are sending all the people to city a. The total costs would
        // be totalA
        int totalA = 0;
        int eachNum = costs.length / 2;
        ArrayList<Integer> refunds = new ArrayList<>();

        for (int i = 0; i < costs.length; i++) {
            totalA += costs[i][0];
            refunds.add(costs[i][1] - costs[i][0]); // refund would be costs of B - costs of A
        }
        // sort the refund array
        Collections.sort(refunds);
        int totalRefunds = 0;
        for (int i = 0; i < eachNum; i++) {
            totalRefunds += refunds.get(i);
        }
        return totalA + totalRefunds;
    }
}