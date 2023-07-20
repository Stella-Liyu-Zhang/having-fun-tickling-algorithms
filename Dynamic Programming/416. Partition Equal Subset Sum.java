class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }
        //If the total sum is odd, it's not possible to partition the array into 2 subsets with equal sums
        if(totalSum % 2 != 0){
            return false;
        }
        /*Then, for each element num in the array, we update the dp array from the targetSum down to num. We set dp[i] to true if either dp[i] is already true (indicating that   the sum i can already be formed using previous elements) or if we can form the sum i - num (indicating that we can form a subset with sum i - num and adding num would give us the sum i).*/

        int targetSum = totalSum/2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;

        for(int num: nums){
            for(int i = targetSum; i >= num; i--){
                dp[i] = dp[i] | dp[i-num];
            }
        }
        return dp[targetSum];
    }
}