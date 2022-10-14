class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) { // first, compare the current element and get the minimum value
                minValue = prices[i]; // if the curr is smaller than minValue, set it to be the minValue
            } else if (prices[i] - minValue > maxProfit) { // if the curr price difference with minValue is bigger than
                                                           // maxProfit
                maxProfit = prices[i] - minValue; // Set the maxProfit to be the bigger gap
            }
        }
        return maxProfit;
    }
}