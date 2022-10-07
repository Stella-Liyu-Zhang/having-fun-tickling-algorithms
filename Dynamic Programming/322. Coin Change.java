class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        //make a dp array that stores the fewest amount of coins that make up to the amount
        //dp[0] --> fewest to make up 0 cent; dp[1] --> fewest to make up 1 cent. 
        int[] dp = new int[amount + 1]; 
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
                }else{
                    break;
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
        }
}