class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int roundedAmount = 0;
        
        if(purchaseAmount%10 < 5){
            roundedAmount =  10*(purchaseAmount/10);
        }else if (purchaseAmount%10 >= 5){
            roundedAmount = 10*(purchaseAmount/10 + 1);
        }
    
        return 100 - roundedAmount;
    }
}