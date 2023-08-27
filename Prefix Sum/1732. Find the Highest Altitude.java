class Solution {
    /*
    [-5,1,5,0,-7]
    0, -5, -4, 1, 0, -3
    */
    public int largestAltitude(int[] gain) {
        int prefixSum = 0;
        int maxsoFar = prefixSum;
        for(int i = 0; i < gain.length; i ++){
            prefixSum += gain[i];
            maxsoFar = Math.max(maxsoFar, prefixSum);
        }
        return maxsoFar;
    }
}