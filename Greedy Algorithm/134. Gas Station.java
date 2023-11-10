class Solution {
    /*
    n gas stations in circlar
    ith is gas[i] amound of gas
    
    fuel in tank - distance < 0

    position
    sum
    total
    
    Gas - cost
    */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int position = 0, currGain = 0, totalGain = 0;
        for(int i = 0; i < gas.length; i ++){
            currGain += gas[i] - cost[i];
            totalGain += gas[i] - cost[i];

            // If we meet a "valley", start over from the next station
            // with 0 initial gas.
            if(currGain < 0){ //if we start from this point, then the amount of gas is 0, not possible
                position = i + 1;
                currGain = 0;
            }
        }
        return totalGain >= 0 ? position : -1;
    }
}