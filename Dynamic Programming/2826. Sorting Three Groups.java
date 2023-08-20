class Solution {
    /*
    We assume:
    from A[0] to A[i - 1] are 0s
    from A[i] to A[j - 1] are 1s
    from A[j] to A[n - 1] are 2s.

    dp[k] means the number of operation we need,
    to make nums increasing from 1 to k.
    */
    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[] {n,n,n,n}; //Initial all dp[k] as n, since at most n elements.

        /*
        update dp[k] = min(dp[k], dp[k - 1]),
        because sequence from 1 to k - 1 is a special kind of
        sequence from 1 to k,
        but missing k in the sequence.
        */
        for(int a: nums){
            dp[a] --;
            dp[2] = Math.min(dp[2], dp[1]);
            dp[3] = Math.min(dp[3], dp[2]);
        }
        return dp[3];
    }
}