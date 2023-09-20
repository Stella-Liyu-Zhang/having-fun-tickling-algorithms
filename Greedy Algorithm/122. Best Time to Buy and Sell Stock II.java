class Solution {
    /*
    Get the biggest gap
    Get the second largest gap

    Valley and peak
    
    - find the peak that immediately follows a valley.
    - Find all the such peak-valley pairs, and add their differences together. 
    */
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int max = 0;
        while(i < prices.length - 1){
            while(i < prices.length - 1 && prices[i] >= prices[i+1]){
                i ++;
            }
            valley = prices[i];

            while(i < prices.length - 1 && prices[i] <= prices[i+1]){
                i ++;
            }
            peak = prices[i];

            max += peak - valley;
        }
        return max;
    }
}