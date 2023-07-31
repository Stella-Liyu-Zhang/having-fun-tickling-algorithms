class Solution {
    /*
    The optimal final result can be derived by keep updating 2 variables skip_i, take_i, which stands for:
    skip_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you skip the ith bucket.
    take_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you take the ith bucket.

    DP formula:
    take[i] = skip[i-1] + values[i];
    skip[i] = Math.max(skip[i-1], take[i-1]);
    take[i] can only be derived from: if you skipped the [i-1]th bucket, and you take bucket[i].
    skip[i] through, can be derived from either take[i-1] or skip[i-1], whatever the bigger;
    */
    public int deleteAndEarn(int[] nums) {
        //sort the nums array
        int[] dp = new int[10001];
        for(int num: nums){
            dp[num] += num;
        }
        int take = 0;
        int skip = 0;
        for(int i = 0; i < 10001; i ++){
            int takei = skip + dp[i];
            int skipi = Math.max(take, skip);
            take = takei;
            skip = skipi;
        }
        return Math.max(take,skip);
    }
}